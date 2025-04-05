package com.example.refactoring2.ch12.ex10.multiSubclass;

public class AfricanSwallow extends Bird {
  private final int numberOfCoconuts;

  public AfricanSwallow(BirdDto data) {
    this(data.name(), data.plumage(), data.numberOfCoconuts());
  }

  public AfricanSwallow(String name, String plumage, int numberOfCoconuts) {
    super(name, plumage);
    this.numberOfCoconuts = numberOfCoconuts;
  }

  @Override
  public Integer airSpeedVelocity() {
    return 40 - 2 * numberOfCoconuts;
  }
}
