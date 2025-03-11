package com.example.refactoring2.ch08.ex2;

import java.util.Objects;

public class AccountType {
  private final String name;
  private final double interestRate;

  public AccountType(String name, double interestRate) {
    this.name = name;
    this.interestRate = interestRate;
  }

  public String getName() {
    return name;
  }

  public double getInterestRate() {
    return interestRate;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    AccountType that = (AccountType) o;
    return Double.compare(interestRate, that.interestRate) == 0 && Objects.equals(name, that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, interestRate);
  }
}
