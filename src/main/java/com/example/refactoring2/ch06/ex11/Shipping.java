package com.example.refactoring2.ch06.ex11;

public class Shipping {

    private final int discountThreshold;
    private final int discountedFee;
    private final int feePerCase;

    public Shipping(int discountThreshold, int discountedFee, int feePerCase) {
        this.discountThreshold = discountThreshold;
        this.discountedFee = discountedFee;
        this.feePerCase = feePerCase;
    }

    public int discountThreshold() {
        return this.discountThreshold;
    }

    public int discountedFee() {
        return this.discountedFee;
    }

    public int feePerCase() {
        return this.feePerCase;
    }
}
