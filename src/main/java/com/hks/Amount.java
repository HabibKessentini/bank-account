package com.hks;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode
@Getter
class Amount {

    private Long value;

    private Amount(Long value) {
        if (value < 0) {
            throw new NegativeAmountException();
        }
        this.value = value;
    }

    static Amount of(Long value) {
        return new Amount(value);
    }

    Amount add(Amount amount) {
        return new Amount(this.value + amount.value);
    }

    Amount subtract(Amount amount) {
        return new Amount(this.value - amount.value);
    }

}
