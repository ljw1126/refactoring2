package com.example.refactoring2.ch10.ex4.bird;

public class BirdFactory {
  private BirdFactory() {}

  public static Bird createBird(Bird bird) {
    return switch (bird.type) {
      case "유럽 제비" -> new EuropeanSwallow(bird);
      case "아프리카 제비" -> new AfricanSwallow(bird);
      case "노르웨이 파랑 앵무" -> new NorwegianBlueParrot(bird);
      default -> new Bird(bird);
    };
  }
}
