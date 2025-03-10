package com.example.refactoring2.ch08.ex2;

public class Customer {
  private final String name;
  private final CustomerContract customerContract;

  public Customer(String name, double discountRate, CustomerContract customerContract) {
    this.name = name;
    this.customerContract = customerContract;
    this.setDiscountRate(discountRate); // 후처리
  }

  public void becomePreferred() {
    this.setDiscountRate(getDiscountRate() + 0.03);
    // do something
  }

  public Amount applyDiscount(Amount amount) {
    return amount.subtract(amount.multiply(getDiscountRate()));
  }

  public String getName() {
    return name;
  }

  public double getDiscountRate() {
    return customerContract.getDiscountRate();
  }

  public void setDiscountRate(double aNumber) {
    this.customerContract.setDiscountRate(aNumber);
  }
}
