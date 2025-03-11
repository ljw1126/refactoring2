package com.example.refactoring2.ch08.ex2;

import java.time.LocalDateTime;
import java.util.Objects;

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

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    CustomerContract that = (CustomerContract) o;
    return Double.compare(discountRate, that.discountRate) == 0
        && Objects.equals(startDate, that.startDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(startDate, discountRate);
  }
}
