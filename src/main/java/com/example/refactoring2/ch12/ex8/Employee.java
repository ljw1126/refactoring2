package com.example.refactoring2.ch12.ex8;

public class Employee extends Party {
  private final Long id;
  private final int monthlyCost;

  public Employee(Long id, String name, int monthlyCost) {
    super(name);
    this.id = id;
    this.monthlyCost = monthlyCost;
  }

  @Override
  public long monthlyCost() {
    return monthlyCost;
  }
}
