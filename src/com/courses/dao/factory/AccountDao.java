package com.courses.dao.factory;

import com.courses.dao.businessobjects.Account;
import com.courses.dao.businessobjects.Customer;

import java.util.Collection;

/**
 * Created by VSulevskiy on 14.09.2015.
 */
public interface AccountDao {
    boolean insertAccount(Account account);
    boolean deleteAccount(Account account);
    Account findAccount(long id);
    boolean updateAccount(Account account);
    Collection<Account> getAccounts();
}
