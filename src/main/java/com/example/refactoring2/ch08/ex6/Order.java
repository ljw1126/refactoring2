package com.example.refactoring2.ch08.ex6;

public class Order {
  private final int units;
  private final boolean isRepeatOrder;

  public Order(int units, boolean isRepeatOrder) {
    this.units = units;
    this.isRepeatOrder = isRepeatOrder;
  }

  public int getUnits() {
    return units;
  }

  public boolean isRepeatOrder() {
    return isRepeatOrder;
  }
}
