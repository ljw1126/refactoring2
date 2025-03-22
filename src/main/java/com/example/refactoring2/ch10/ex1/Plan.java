package com.example.refactoring2.ch10.ex1;

import java.time.LocalDate;

public class Plan {
  private final LocalDate summerStart;
  private final LocalDate summerEnd;
  private final double summerRate;
  private final double regularRate;
  private final int regularServiceCharge;

  public Plan(
      LocalDate summerStart,
      LocalDate summerEnd,
      double summerRate,
      double regularRate,
      int regularServiceCharge) {
    this.summerStart = summerStart;
    this.summerEnd = summerEnd;
    this.summerRate = summerRate;
    this.regularRate = regularRate;
    this.regularServiceCharge = regularServiceCharge;
  }

  public LocalDate summerStart() {
    return summerStart;
  }

  public LocalDate summerEnd() {
    return summerEnd;
  }

  public double summerRate() {
    return summerRate;
  }

  public double regularRate() {
    return regularRate;
  }

  public int regularServiceCharge() {
    return regularServiceCharge;
  }
}
