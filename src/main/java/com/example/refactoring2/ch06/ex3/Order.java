package com.example.refactoring2.ch06.ex3;

public class Order {
    private final int quantity;
    private final int itemPrice;

    public Order(int quantity, int itemPrice) {
        this.quantity = quantity;
        this.itemPrice = itemPrice;
    }

    public double price() {
        int basePrice = quantity * itemPrice;
        double quantityDiscount = Math.max(0, quantity - 500) * itemPrice * 0.05;
        double shipping = Math.min(basePrice * 0.1, 100);

        return basePrice - quantityDiscount + shipping;
    }
}
