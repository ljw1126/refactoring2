package com.example.refactoring2.ch07.ex4;

public class Order {
    private final int quantity;
    private final Item item;

    public Order(int quantity, Item item) {
        this.quantity = quantity;
        this.item = item;
    }

    public double price() {
        return basePrice() * discountFactor();
    }

    private int basePrice() {
        return this.quantity * this.item.getPrice();
    }

    private double discountFactor() {
        double discountFactor = 0.98;
        if(basePrice() > 1000) discountFactor -= 0.03;
        return discountFactor;
    }
}
