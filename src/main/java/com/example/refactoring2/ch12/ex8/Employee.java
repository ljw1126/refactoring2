package com.example.refactoring2.ch12.ex8;

public class Employee {
  private final Long id;
  private final String name;
  private final int monthlyCost;

  public Employee(Long id, String name, int monthlyCost) {
    this.id = id;
    this.name = name;
    this.monthlyCost = monthlyCost;
  }

  public long annualCost() {
    return this.monthlyCost * 12L;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getMonthlyCost() {
    return monthlyCost;
  }
}
