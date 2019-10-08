package com.hks.domain;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
class Balance {

    private final Amount amount;

    private Balance(Long amount) {
        this.amount = Amount.of(amount);
    }

    private Balance(Amount amount) {
        this.amount = amount;
    }

    static Balance of(Long amount) {
        return new Balance(amount);
    }

    Balance deposit(Amount amount) {
        return new Balance(this.amount.add(amount));
    }

    Balance withdraw(Amount amount) {
        return new Balance(this.amount.subtract(amount));
    }

    Long getValue() {
        return this.amount.getValue();
    }


}
