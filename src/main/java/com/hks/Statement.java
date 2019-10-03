package com.hks;

import java.util.Objects;

public class Statement {

    private final Amount amount;
    private final String date;
    private final Balance balance;
    private final String operationType;

    public Statement(Amount amount, String date, Balance balance, String operationType) {
        this.amount = amount;
        this.date = date;
        this.balance = balance;
        this.operationType = operationType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Statement statement = (Statement) o;
        return Objects.equals(date, statement.date) &&
                Objects.equals(amount, statement.amount) &&
                Objects.equals(balance, statement.balance) &&
                Objects.equals(operationType, statement.operationType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, amount, balance, operationType);
    }


}
