package com.example.refactoring2.ch10.ex4;

public class EuropeanSwallow extends Bird {
  public EuropeanSwallow(Bird bird) {
    super(bird);
  }

  @Override
  public String plumage() {
    return "보통이다";
  }
}
