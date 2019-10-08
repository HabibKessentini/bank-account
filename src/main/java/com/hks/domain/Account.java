package com.hks.domain;

import java.util.List;

public class Account {

    private StatementStore statementsStore;
    private StatementPrinter statementPrinter;

    private Account(StatementPrinter statementPrinter) {
        this.statementsStore = StatementStore.create();
        this.statementPrinter = statementPrinter;
    }

    public static Account create(StatementPrinter statementPrinter) {
        return new Account(statementPrinter);
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

    public void printStatement() {
        statementPrinter.print(getStatements());
    }
}
