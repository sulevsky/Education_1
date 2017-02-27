package com.courses.jdbcdao_11.factory.xml;

import com.courses.jdbcdao_11.businessobjects.Account;
import com.courses.jdbcdao_11.businessobjects.Customer;
import com.courses.jdbcdao_11.factory.CustomerDao;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by VSulevskiy on 14.09.2015.
 */
public class XmlCustomerDao implements CustomerDao {
    @Override
    public boolean insertCustomer(Customer customer) {
        generateXml(customer);
        return true;
    }

    @Override
    public boolean deleteCustomer(Customer customer) {
        String filePath = getFileNameForCustomer(customer);
        Path path = Paths.get(filePath);
        try {
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public Customer findCustomer(long id) {
        return getFromXml(id);
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        deleteCustomer(customer);
        insertCustomer(customer);
        return true;
    }

    @Override
    public Collection<Customer> getCustomers() {
        throw new UnsupportedOperationException("This operation is not supported yet");
    }

    private void generateXml(Customer customer) {
        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // root element
            Document doc = docBuilder.newDocument();
            Element rootElementAccount = doc.createElement("customer");
            doc.appendChild(rootElementAccount);

            Element customerId = doc.createElement("customerId");
            customerId.appendChild(doc.createTextNode(customer.getId()+""));
            rootElementAccount.appendChild(customerId);

            Element firstName = doc.createElement("firstName");
            firstName.appendChild(doc.createTextNode(customer.getFirstName() + ""));
            rootElementAccount.appendChild(firstName);

            Element lastName = doc.createElement("lastName");
            lastName.appendChild(doc.createTextNode(customer.getLastName() + ""));
            rootElementAccount.appendChild(lastName);

            Element accounts = doc.createElement("accounts");
            for(Account account : customer.getAccounts()){
                Element ac = doc.createElement("account");
                ac.appendChild(doc.createTextNode(account.getId() + ""));
                accounts.appendChild(ac);
            }
            rootElementAccount.appendChild(accounts);

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory
                    .newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(
                    "{http://xml.apache.org/xslt}indent-amount", "4");
            DOMSource source = new DOMSource(doc);
            String fileNameForCustomer = getFileNameForCustomer(customer);
            StreamResult result = new StreamResult(new File(fileNameForCustomer));

            transformer.transform(source, result);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    private Customer getFromXml(long id) {
        try {

            String fileNameForCutomer = getFileNameForId(id);
            File file = new File(fileNameForCutomer);
            DocumentBuilderFactory docFactory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(file);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("customer");
            //TODO revise this block
            String idNode = nList.item(0).getChildNodes().item(1).getTextContent();
            Long idFromFile = Long.parseLong(idNode);
            String firstName = nList.item(0).getChildNodes().item(3).getTextContent();
            String lastName = nList.item(0).getChildNodes().item(5).getTextContent();

            int accountNum = doc.getDocumentElement().getElementsByTagName("account").getLength();
            List<Account> accounts = new ArrayList<>();
            for (int i = 0; i < accountNum; i++) {
                String parsedAccId = doc.getDocumentElement().getElementsByTagName("account").item(i).getTextContent();
                long accId = Long.parseLong(parsedAccId);
                accounts.add(new Account(accId));
            }
            Customer customer = new Customer(idFromFile,firstName, lastName, accounts);

            return customer;

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    private String getFileNameForCustomer(Customer customer) {
        return getFileNameForId(customer.getId());
    }
    private String getFileNameForId(long id) {
        return "resourses/customer_" + id + ".xml";
    }


}
