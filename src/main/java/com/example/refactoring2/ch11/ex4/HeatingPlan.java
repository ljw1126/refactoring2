package com.example.refactoring2.ch11.ex4;

public class HeatingPlan {
  private final TemperatureRange temperatureRange;

  public HeatingPlan(TemperatureRange temperatureRange) {
    this.temperatureRange = temperatureRange;
  }

  public boolean withinRange(TemperatureRange aNumberRange) {
    return (aNumberRange.low() >= this.temperatureRange.low())
        && (aNumberRange.high() <= this.temperatureRange.high());
  }
}
