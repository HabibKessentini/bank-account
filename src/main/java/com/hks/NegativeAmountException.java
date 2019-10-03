package com.hks;

public class NegativeAmountException extends RuntimeException {

    NegativeAmountException() {
        super("Business Error: Negative amounts are not allowed.");
    }


}
