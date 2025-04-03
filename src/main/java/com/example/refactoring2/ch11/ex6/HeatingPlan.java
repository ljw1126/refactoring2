package com.example.refactoring2.ch11.ex6;

public class HeatingPlan {
  private final int max;
  private final int min;

  public HeatingPlan(int max, int min) {
    this.max = max;
    this.min = min;
  }

  public int targetTemperature(int selectedTemperature) {
    if (selectedTemperature > this.max) {
      return this.max;
    } else if (selectedTemperature < this.min) {
      return this.min;
    }

    return selectedTemperature;
  }
}
