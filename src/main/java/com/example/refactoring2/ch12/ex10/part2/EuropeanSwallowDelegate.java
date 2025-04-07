package com.example.refactoring2.ch12.ex10.part2;

public class EuropeanSwallowDelegate extends SpeciesDelegate {

  public EuropeanSwallowDelegate(Bird bird) {
    super(bird);
  }

  @Override
  public Integer airSpeedVelocity() {
    return 35;
  }
}
