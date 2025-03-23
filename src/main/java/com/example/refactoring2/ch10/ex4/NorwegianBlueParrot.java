package com.example.refactoring2.ch10.ex4;

public class NorwegianBlueParrot extends Bird {
  public NorwegianBlueParrot(Bird bird) {
    super(bird);
  }

  @Override
  public String plumage() {
    return (voltage > 100) ? "그을렸다" : "예쁘다";
  }

  @Override
  public Integer airSpeedVelocity() {
    return isNailed ? 0 : 10 + voltage / 10;
  }
}
