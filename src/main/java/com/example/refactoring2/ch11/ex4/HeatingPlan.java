package com.example.refactoring2.ch11.ex4;

public class HeatingPlan {
  private final TemperatureRange temperatureRange;

  public HeatingPlan(TemperatureRange temperatureRange) {
    this.temperatureRange = temperatureRange;
  }

  public boolean withinRange(int bottom, int top) {
    return (bottom >= this.temperatureRange.low()) && (top <= this.temperatureRange.high());
  }
}
