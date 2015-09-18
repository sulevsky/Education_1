package com.courses.jdbcdao_11.factory.xml;

import com.courses.jdbcdao_11.factory.AccountDao;
import com.courses.jdbcdao_11.factory.CustomerDao;
import com.courses.jdbcdao_11.factory.DaoFactory;

/**
 * Created by VSulevskiy on 14.09.2015.
 */
public class XmlDaoFactory extends DaoFactory {
    @Override
    public CustomerDao getCustomerDao() {
        return new XmlCustomerDao();
    }

    @Override
    public AccountDao getAccountDao() {
        return new XmlAccountDao();
    }
}
