package com.example.refactoring2.ch10.ex4;

public class Bird {
  private final String name;
  private final String type;
  private final int numberOfCoconuts;
  private final int voltage;
  private final boolean isNailed;

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
    return switch (type) {
      case "유럽 제비" -> "보통이다";
      case "아프리카 제비" -> (numberOfCoconuts > 2) ? "지쳤다" : "보통이다";
      case "노르웨이 파랑 앵무" -> (voltage > 100) ? "그을렸다" : "예쁘다";
      default -> "알 수 없다";
    };
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
