package com.example.refactoring2.ch12.ex10.part2;

public class NorwegianBlueParrotDelegate extends SpeciesDelegate {
  private final int voltage;
  private final boolean isNailed;

  public NorwegianBlueParrotDelegate(BirdDto data, Bird bird) {
    super(bird);
    this.voltage = data.voltage();
    this.isNailed = data.isNailed();
  }

  @Override
  public String plumage() {
    if (voltage > 100) return "그을렸다";

    return this.bird.plumage().isBlank() ? "예쁘다" : this.bird.plumage();
  }

  @Override
  public Integer airSpeedVelocity() {
    return isNailed ? 0 : 10 + voltage / 10;
  }
}
