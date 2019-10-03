package com.hks;

import com.hks.core.Console;

import java.util.List;

public class Account {

    private StatementStore statementsStore;
    private StatementPrinter statementPrinter;

    private Account(Console console) {
        this.statementsStore = StatementStore.create();
        this.statementPrinter = StatementPrinter.create(console);
    }

    public static Account create(Console console) {
        return new Account(console);
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

    public void printStatements() {
        statementPrinter.print(getStatements());
    }
}
