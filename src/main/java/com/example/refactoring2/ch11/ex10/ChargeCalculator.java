package com.example.refactoring2.ch11.ex10;

public class ChargeCalculator {

  public double charge(Customer customer, int usage, Provider provider) {
    double baseCharge = customer.baseRate() * usage;
    return baseCharge + provider.connectionCharge();
  }
}
