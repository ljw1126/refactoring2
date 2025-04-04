package com.example.refactoring2.ch12.ex8;

public abstract class Party {
  protected final String name;

  protected Party(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public long annualCost() {
    return monthlyCost() * 12L;
  }

  abstract long monthlyCost();
}
