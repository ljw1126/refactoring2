package com.example.refactoring2.ch10.ex6;

public class Customer {
  private final double discountRate;

  public Customer(double discountRate) {
    if (discountRate < 0.0) {
      throw new IllegalArgumentException("Discount rate must be greater than or equal to 0.");
    }

    this.discountRate = discountRate;
  }

  public double applyDiscount(int aNumber) {
    if (this.discountRate < 0.0) return aNumber;

    return aNumber - (this.discountRate * aNumber);
  }
}
