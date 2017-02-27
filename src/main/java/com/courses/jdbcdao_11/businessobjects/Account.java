package com.courses.jdbcdao_11.businessobjects;

import java.math.BigDecimal;

/**
 * Created by VSulevskiy on 14.09.2015.
 */
public class Account {
    private final long id;
    private BigDecimal balance;

    public Account(long id) {
        this.id = id;
        this.balance = BigDecimal.ZERO;
    }

    public Account(long id, BigDecimal balance) {
        this.id = id;
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public long getId() {
        return id;
    }
}
