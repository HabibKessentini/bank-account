package com.hks;

public class Account {

    private Long balance;

    private Account() {
        this.balance = 0L;
    }

    public static Account create() {
        return new Account();
    }

    public void deposit(Long amount) {
        balance += amount;
    }

    public void withdraw(Long amount) {
        balance -= amount;
    }

    public Long getBalance() {
        return balance;
    }


}
