package com.example.refactoring2.ch12.ex1;

public class Department extends Party {

    private final int monthlyCost;

    public Department(int monthlyCost) {
        this.monthlyCost = monthlyCost;
    }

    @Override
    public int annualCost() {
        return this.monthlyCost * 12;
    }
}
