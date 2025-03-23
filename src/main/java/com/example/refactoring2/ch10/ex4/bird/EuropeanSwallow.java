package com.example.refactoring2.ch10.ex4.bird;

public class EuropeanSwallow extends Bird {
  public EuropeanSwallow(Bird bird) {
    super(bird);
  }

  @Override
  public String plumage() {
    return "보통이다";
  }

  @Override
  public Integer airSpeedVelocity() {
    return 35;
  }
}
