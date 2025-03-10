package com.example.refactoring2.ch08.ex2;

import java.time.LocalDateTime;

public class CustomerContract {
  private final LocalDateTime startDate;
  private double discountRate;

  public CustomerContract(LocalDateTime startDate) {
    this(startDate, 0.0);
  }

  public CustomerContract(LocalDateTime startDate, double discountRate) {
    this.startDate = startDate;
    this.discountRate = discountRate;
  }

  public double getDiscountRate() {
    return discountRate;
  }

  public void setDiscountRate(double discountRate) {
    this.discountRate = discountRate;
  }
}
