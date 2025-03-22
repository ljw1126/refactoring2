package com.example.refactoring2.ch10.ex6;

public class Customer {
  private final double discountRate;

  public Customer(double discountRate) {
    this.discountRate = discountRate;
  }

  public double applyDiscount(int aNumber) {
    return (this.discountRate > 0.0) ? aNumber - (this.discountRate * aNumber) : aNumber;
  }
}
