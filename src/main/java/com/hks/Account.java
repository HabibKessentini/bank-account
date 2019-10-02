package com.hks;

public class Account {

    private Long balance;

    public Account() {
        this.balance = 0L;
    }

    public void deposit(Long amount) {
        balance += amount;
    }

    public Long getBalance() {
        return balance;
    }


}
