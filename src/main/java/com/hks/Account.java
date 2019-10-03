package com.hks;

import java.util.List;

public class Account {

    private StatementStore statementsStore;

    private Account() {
        this.statementsStore = StatementStore.create();
    }

    public static Account create() {
        return new Account();
    }

    public void deposit(Long amount, String date) {
        statementsStore.deposit(Amount.of(amount), date);
    }

    public void withdraw(Long amount, String date) {
        statementsStore.withdraw(Amount.of(amount), date);
    }

    public Long getBalance() {
        return statementsStore.getBalance().getValue();
    }

    public List<Statement> getStatements() {
        return statementsStore.getAll();
    }


}
