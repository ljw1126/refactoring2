package com.example.refactoring2.ch10.ex1;

import java.time.LocalDate;

public class ServiceCharge {
  private final Plan plan;

  public ServiceCharge(Plan plan) {
    this.plan = plan;
  }

  public double charge(int quantity, LocalDate aDate) {
    if (!aDate.isBefore(plan.summerStart()) && !aDate.isAfter(plan.summerEnd())) {
      return quantity * plan.summerRate();
    }

    return quantity * plan.regularRate() + plan.regularServiceCharge();
  }
}
