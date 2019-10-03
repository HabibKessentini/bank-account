package com.hks;

import java.util.Objects;

class Amount {

    private Long value;

    private Amount(Long value) {
        if (value < 0) {
            throw new NegativeAmountException();
        }
        this.value = value;
    }

    public static Amount of(Long value) {
        return new Amount(value);
    }

    public void add(Amount amount) {
        this.value += amount.value;
    }

    public void subtract(Amount amount) {
        this.value -= amount.value;
    }

    public Long getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount amount = (Amount) o;
        return Objects.equals(value, amount.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }


}
