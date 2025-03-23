package com.example.refactoring2.ch10.ex4;

public class AfricanSwallow extends Bird {
  public AfricanSwallow(Bird bird) {
    super(bird);
  }

  @Override
  public String plumage() {
    return (numberOfCoconuts > 2) ? "지쳤다" : "보통이다";
  }

  @Override
  public Integer airSpeedVelocity() {
    return 40 - 2 * numberOfCoconuts;
  }
}
