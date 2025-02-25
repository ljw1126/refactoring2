package com.example.refactoring2.ch06.ex9;

public class Reading {
    private final String customer;
    private final int quantity;
    private final int month;
    private final int year;

    public Reading(String customer, int quantity, int month, int year) {
        this.customer = customer;
        this.quantity = quantity;
        this.month = month;
        this.year = year;
    }

    public  int taxableChargeFn() {
        return Math.max(0, this.baseCharge() - taxThreshold(this.year));
    }

    private int taxThreshold(int year) {
        return 1;
    }

    public int baseCharge() {
        return baseRate(this.month, this.year) * this.quantity;
    }

    private int baseRate(int month, int year) {
        return 1;
    }

    public String getCustomer() {
        return customer;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
}
