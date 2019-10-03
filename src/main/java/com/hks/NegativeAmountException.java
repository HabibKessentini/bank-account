package com.hks;

public class NegativeAmountException extends RuntimeException {
    public NegativeAmountException() {
        super("Business Error: Negative amounts are not allowed.");
    }
}
