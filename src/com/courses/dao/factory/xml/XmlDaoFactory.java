package com.courses.dao.factory.xml;

import com.courses.dao.factory.AccountDao;
import com.courses.dao.factory.CustomerDao;
import com.courses.dao.factory.DaoFactory;

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
