package com.example.refactoring2.ch10.ex4;

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

  public static Bird createBird(Bird bird) {
    return switch (bird.type) {
      case "유럽 제비" -> new EuropeanSwallow(bird);
      case "아프리카 제비" -> new AfricanSwallow(bird);
      case "노르웨이 파랑 앵무" -> new NorwegianBlueParrot(bird);
      default -> new Bird(bird);
    };
  }

  public String plumage() {
    return "알 수 없다";
  }

  public Integer airSpeedVelocity() {
    return switch (type) {
      case "유럽 제비" -> 35;
      case "아프리카 제비" -> 40 - 2 * numberOfCoconuts;
      case "노르웨이 파랑 앵무" -> isNailed ? 0 : 10 + voltage / 10;
      default -> 0;
    };
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
