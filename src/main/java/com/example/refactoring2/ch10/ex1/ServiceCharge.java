package com.example.refactoring2.ch10.ex1;

import java.time.LocalDate;

public class ServiceCharge {
  private final Plan plan;

  public ServiceCharge(Plan plan) {
    this.plan = plan;
  }

  public double charge(int quantity, LocalDate aDate) {
    return summer(aDate) ? summerCharge(quantity) : regularCharge(quantity);
  }

  private boolean summer(LocalDate aDate) {
    return !aDate.isBefore(plan.summerStart()) && !aDate.isAfter(plan.summerEnd());
  }

  private double summerCharge(int quantity) {
    return quantity * plan.summerRate();
  }

  private double regularCharge(int quantity) {
    return quantity * plan.regularRate() + plan.regularServiceCharge();
  }
}
