package com.hks;

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


}
