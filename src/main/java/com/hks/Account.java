package com.hks;


import java.util.ArrayList;
import java.util.List;

public class Account {

    private Balance balance;
    private List<Statement> statements;

    private Account() {
        this.balance = Balance.of(0L);
        this.statements = new ArrayList<>();
    }

    public static Account create() {
        return new Account();
    }

    public void deposit(Long amount, String date) {
        Statement statement = new Statement(Amount.of(amount), date, Balance.of(balance.getValue()), "deposit");
        statements.add(statement);
        balance.deposit(amount);
    }

    public void withdraw(Long amount, String date) {
        Statement statement = new Statement(Amount.of(amount), date, Balance.of(balance.getValue()), "withdraw");
        statements.add(statement);
        balance.withdraw(amount);
    }

    public Long getBalance() {
        return balance.getValue();
    }

    public List<Statement> getStatements() {
        return statements;
    }

}
