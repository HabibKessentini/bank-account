package com.hks.domain;

import lombok.AllArgsConstructor;

import java.util.function.BiFunction;

@AllArgsConstructor
public enum OperationType {

    DEPOSIT(Balance::deposit),
    WITHDRAWAL(Balance::withdraw);

    private BiFunction<Balance, Amount, Balance> balanceFunction;

    public Balance calculateBalance(Balance initialBalance, Amount amount) {
        return balanceFunction.apply(initialBalance, amount);
    }


}
