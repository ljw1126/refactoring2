package com.example.refactoring2.ch08.ex2;

import java.time.LocalDateTime;

public class Customer {
  private final String name;
  private double discountRate;
  private final CustomerContract customerContract;

  public Customer(String name, double discountRate) {
    this(name, discountRate, new CustomerContract(LocalDateTime.now()));
  }

  public Customer(String name, double discountRate, CustomerContract customerContract) {
    this.name = name;
    this.discountRate = discountRate;
    this.customerContract = customerContract;
  }

  public void becomePreferred() {
    this.discountRate += 0.03;
    // do something
  }

  public Amount applyDiscount(Amount amount) {
    return amount.subtract(amount.multiply(discountRate));
  }

  public String getName() {
    return name;
  }

  public double getDiscountRate() {
    return discountRate;
  }
}
