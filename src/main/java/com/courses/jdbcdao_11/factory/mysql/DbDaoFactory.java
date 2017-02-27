package com.courses.jdbcdao_11.factory.mysql;

import com.courses.jdbcdao_11.factory.AccountDao;
import com.courses.jdbcdao_11.factory.CustomerDao;
import com.courses.jdbcdao_11.factory.DaoFactory;

/**
 * Created by VSulevskiy on 14.09.2015.
 */
public class DbDaoFactory extends DaoFactory {
    @Override
    public CustomerDao getCustomerDao() {
        return new DbCustomerDao();
    }

    @Override
    public AccountDao getAccountDao() {
        return new DbAccountDao();
    }
}
