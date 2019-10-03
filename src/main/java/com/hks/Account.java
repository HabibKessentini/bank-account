package com.hks;


public class Account {

    private Balance balance;

    private Account() {
        this.balance = Balance.of(0L);
    }

    public static Account create() {
        return new Account();
    }

    public void deposit(Long amount) {
        balance.deposit(amount);
    }

    public void withdraw(Long amount) {
        balance.withdraw(amount);
    }

    public Long getBalance() {
        return balance.getValue();
    }


}
