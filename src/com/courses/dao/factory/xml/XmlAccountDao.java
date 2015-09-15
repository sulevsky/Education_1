package com.courses.dao.factory.xml;

import com.courses.dao.businessobjects.Account;
import com.courses.dao.factory.AccountDao;
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
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;

/**
 * Created by VSulevskiy on 14.09.2015.
 */
public class XmlAccountDao implements AccountDao {
    @Override
    public boolean insertAccount(Account account) {
        generateXml(account);
        return true;
    }

    @Override
    public boolean deleteAccount(Account account) {
        String filePath = getFileNameForAccount(account);
        Path path = Paths.get(filePath);
        try {
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public Account findAccount(long id) {
        return getFromXml(id);
    }

    @Override
    public boolean updateAccount(Account account) {
        //update everything except id
        deleteAccount(account);
        insertAccount(account);
        return true;
    }

    @Override
    public Collection<Account> getAccounts() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    private void generateXml(Account account) {
        try {

            DocumentBuilderFactory docFactory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // root element
            Document doc = docBuilder.newDocument();
            Element rootElementAccount = doc.createElement("account");
            doc.appendChild(rootElementAccount);

            Element accountId = doc.createElement("accountId");
            accountId.appendChild(doc.createTextNode(account.getId()+""));
            rootElementAccount.appendChild(accountId);

            Element accountBalance = doc.createElement("accountBalance");
            accountBalance.appendChild(doc.createTextNode(account.getBalance()+""));
            rootElementAccount.appendChild(accountBalance);

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory
                    .newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(
                    "{http://xml.apache.org/xslt}indent-amount", "4");
            DOMSource source = new DOMSource(doc);
            String fileNameForAccount = getFileNameForAccount(account);
            StreamResult result = new StreamResult(new File(fileNameForAccount));

            transformer.transform(source, result);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    private Account getFromXml(long id) {
        try {

            String fileNameForAccount = getFileNameForId(id);
            File file = new File(fileNameForAccount);
            DocumentBuilderFactory docFactory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(file);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("account");
            //TODO revise this block
            String idNode = nList.item(0).getChildNodes().item(1).getTextContent();
            String balanceNode = nList.item(0).getChildNodes().item(3).getTextContent();

            Long idFromFile = Long.parseLong(idNode);
            BigDecimal balance = BigDecimal.valueOf(Double.parseDouble(balanceNode));

            Account account = new Account(idFromFile,balance);
            return account;

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    private String getFileNameForAccount(Account account) {
        return getFileNameForId(account.getId());
    }
    private String getFileNameForId(long id) {
        return "resourses/account_" + id + ".xml";
    }

//TODO    isPresent()
}
