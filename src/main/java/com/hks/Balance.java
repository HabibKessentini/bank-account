package com.hks;

import java.util.Objects;

public class Balance {

    private final Amount amount;

    private Balance(Long amount) {
        this.amount = Amount.of(amount);
    }

    public static Balance of(Long amount) {
        return new Balance(amount);
    }

    public void deposit(Long amount) {
        this.amount.add(Amount.of(amount));
    }

    public void withdraw(Long amount) {
        this.amount.subtract(Amount.of(amount));
    }

    public Long getValue() {
        return this.amount.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Balance balance = (Balance) o;
        return Objects.equals(amount, balance.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }


}
