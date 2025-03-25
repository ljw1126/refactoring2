package com.example.refactoring2.ch10.ex4.bird;

public class Bird {
  protected final String name;
  protected final String type;
  protected final int numberOfCoconuts;
  protected final int voltage;
  protected final boolean isNailed;

  public Bird(Bird bird) {
    this(bird.name, bird.type, bird.numberOfCoconuts, bird.voltage, bird.isNailed);
  }

  public Bird(String name, String type, int numberOfCoconuts, int voltage, boolean isNailed) {
    this.name = name;
    this.type = type;
    this.numberOfCoconuts = numberOfCoconuts;
    this.voltage = voltage;
    this.isNailed = isNailed;
  }

  public String plumage() {
    return "알 수 없다";
  }

  public Integer airSpeedVelocity() {
    return 0;
  }

  public String name() {
    return name;
  }

  public String type() {
    return type;
  }

  public int numberOfCoconuts() {
    return numberOfCoconuts;
  }

  public int voltage() {
    return voltage;
  }

  public boolean isNailed() {
    return isNailed;
  }
}
