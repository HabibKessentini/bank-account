package com.hks.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import static com.hks.domain.OperationType.DEPOSIT;
import static com.hks.domain.OperationType.WITHDRAWAL;

@EqualsAndHashCode
@Getter
public class Statement {

    private final Amount amount;
    private final String date;
    private final Balance initialBalance;
    private final OperationType operationType;

    private Statement(Amount amount, String date, Balance initialBalance, OperationType operationType) {
        this.amount = amount;
        this.date = date;
        this.initialBalance = initialBalance;
        this.operationType = operationType;
    }

    public static Statement createDeposit(Amount amount, String date, Balance balance) {
        return new Statement(amount, date, balance, DEPOSIT);
    }

    public static Statement createWithdrawal(Amount amount, String date, Balance balance) {
        return new Statement(amount, date, balance, WITHDRAWAL);
    }

    Balance getFinalBalance() {
        return operationType.calculateBalance(initialBalance, amount);
    }
}
