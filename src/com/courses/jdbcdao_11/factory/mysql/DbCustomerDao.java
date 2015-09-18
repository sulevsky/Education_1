package com.courses.jdbcdao_11.factory.mysql;

import com.courses.jdbcdao_11.businessobjects.Customer;
import com.courses.jdbcdao_11.factory.CustomerDao;

import java.util.Collection;

/**
 * Created by VSulevskiy on 14.09.2015.
 */
public class DbCustomerDao implements CustomerDao {
    @Override
    public boolean insertCustomer(Customer customer) {
        return false;
    }

    @Override
    public boolean deleteCustomer(Customer customer) {
        return false;
    }

    @Override
    public Customer findCustomer(long id) {
        return null;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        return false;
    }

    @Override
    public Collection<Customer> getCustomers() {
        return null;
    }
}
