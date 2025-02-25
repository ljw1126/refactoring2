package com.example.refactoring2.ch06.ex11;

public class Product {
    private final int basePrice;
    private final int discountThreshold;
    private final int discountRate;

    public Product(int basePrice, int discountThreshold, int discountRate) {
        this.basePrice = basePrice;
        this.discountThreshold = discountThreshold;
        this.discountRate = discountRate;
    }

    public int basePrice() {
        return this.basePrice;
    }

    public int discountThreshold() {
        return this.discountThreshold;
    }

    public int discountRate() {
        return this.discountRate;
    }
}
