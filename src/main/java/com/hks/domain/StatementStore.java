package com.hks.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

class StatementStore {

    private List<Statement> statements;

    private StatementStore() {
        this.statements = new ArrayList<>();
    }

    static StatementStore create() {
        return new StatementStore();
    }

    void deposit(Amount amount, String date) {
        statements.add(Statement.createDeposit(amount, date, getBalance()));
    }

    void withdraw(Amount amount, String date) {
        statements.add(Statement.createWithdrawal(amount, date, getBalance()));
    }

    Balance getBalance() {
        return getLastStatement()
                .map(Statement::getFinalBalance)
                .orElse(Balance.of(0L));
    }

    private Optional<Statement> getLastStatement() {
        if (statements.isEmpty()) {
            return Optional.empty();
        }
        Statement statement = statements.get(statements.size() - 1);
        return Optional.of(statement);
    }

    List<Statement> getAll() {
        return Collections.unmodifiableList(statements);
    }
}
