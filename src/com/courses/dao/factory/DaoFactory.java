package com.courses.dao.factory;

import com.courses.dao.factory.mysql.DbDaoFactory;
import com.courses.dao.factory.xml.XmlDaoFactory;

/**
 * Created by VSulevskiy on 14.09.2015.
 */
public abstract class DaoFactory {
    public enum DataSourceType{
        XML,
        RDB
    }
    public abstract CustomerDao getCustomerDao();
    public abstract AccountDao getAccountDao();

    public static DaoFactory getDaoFactory(DataSourceType dataSourceType){
        switch (dataSourceType){
            case XML:
                return new XmlDaoFactory();
            case RDB:
                return new DbDaoFactory();
            default:
                throw new RuntimeException("Please specify correct exception and data source");
        }
    }
}
