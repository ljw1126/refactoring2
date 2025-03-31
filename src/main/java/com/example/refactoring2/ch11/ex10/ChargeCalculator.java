package com.example.refactoring2.ch11.ex10;

public class ChargeCalculator {

  private final Customer customer;
  private final int usage;
  private final Provider provider;

  public ChargeCalculator(Customer customer, int usage, Provider provider) {
    this.customer = customer;
    this.usage = usage;
    this.provider = provider;
  }

  public double charge() {
    return this.baseCharge() + this.provider.connectionCharge();
  }

  private double baseCharge() {
    return this.customer.baseRate() * this.usage;
  }
}
