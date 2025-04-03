package com.example.refactoring2.ch11.ex5;

public class Order {
    private final int quantity;
    private final int itemPrice;

    public Order(int quantity, int itemPrice) {
        this.quantity = quantity;
        this.itemPrice = itemPrice;
    }

    public double finalPrice() {
        int basePrice = this.quantity * this.itemPrice;
        return this.discountPrice(basePrice);
    }

    private int discountLevel() {
        return (this.quantity > 100) ? 2 : 1;
    }

    private double discountPrice(int basePrice) {
        return switch (this.discountLevel()) {
            case 1 -> basePrice * 0.95;
            case 2 -> basePrice * 0.9;
            default -> throw new IllegalStateException("Unexpected discountLevel: " + this.discountLevel());
        };
    }
}
