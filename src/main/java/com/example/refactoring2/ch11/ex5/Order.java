package com.example.refactoring2.ch11.ex5;

public class Order {
    private int quantity;
    private int itemPrice;

    public Order(int quantity, int itemPrice) {
        this.quantity = quantity;
        this.itemPrice = itemPrice;
    }

    public double finalPrice() {
        int basePrice = this.quantity * this.itemPrice;
        int discountLevel = this.quantity > 100 ? 2 : 1;
        return this.discountPrice(basePrice, discountLevel);
    }

    private double discountPrice(int basePrice, int discountLevel) {
        return switch (discountLevel) {
            case 1 -> basePrice * 0.95;
            case 2 -> basePrice * 0.9;
            default -> throw new IllegalStateException("Unexpected discountLevel: " + discountLevel);
        };
    }
}
