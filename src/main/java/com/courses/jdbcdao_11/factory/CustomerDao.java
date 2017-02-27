package com.courses.jdbcdao_11.factory;

import com.courses.jdbcdao_11.businessobjects.Customer;

import java.util.Collection;

/**
 * Created by VSulevskiy on 14.09.2015.
 */
public interface CustomerDao {
    boolean insertCustomer(Customer customer);
    boolean deleteCustomer(Customer customer);
    Customer findCustomer(long id);
    boolean updateCustomer(Customer customer);
    Collection<Customer> getCustomers();
}
