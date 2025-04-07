package com.example.refactoring2.ch12.ex10.part2;

public class NorwegianBlueParrotDelegate extends SpeciesDelegate {
  private final int voltage;
  private final boolean isNailed;

  public NorwegianBlueParrotDelegate(BirdDto data) {
    this.voltage = data.voltage();
    this.isNailed = data.isNailed();
  }

  @Override
  public String plumage(String value) {
    if (voltage > 100) return "그을렸다";

    return value.isBlank() ? "예쁘다" : value;
  }

  @Override
  public Integer airSpeedVelocity() {
    return isNailed ? 0 : 10 + voltage / 10;
  }
}
