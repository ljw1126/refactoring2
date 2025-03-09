package com.example.refactoring2.ch08.ex6;

public class PricingPlan {
  private final int base;
  private final int unitCharge;
  private final int discountThreshold;
  private final double discountFactor;

  public PricingPlan(int base, int unitCharge, int discountThreshold, double discountFactor) {
    this.base = base;
    this.unitCharge = unitCharge;
    this.discountThreshold = discountThreshold;
    this.discountFactor = discountFactor;
  }

  public int getBase() {
    return base;
  }

  public int getUnitCharge() {
    return unitCharge;
  }

  public int getDiscountThreshold() {
    return discountThreshold;
  }

  public double getDiscountFactor() {
    return discountFactor;
  }
}
