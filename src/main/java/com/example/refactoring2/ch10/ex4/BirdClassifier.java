package com.example.refactoring2.ch10.ex4;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BirdClassifier {

  private BirdClassifier() {}

  public static Map<String, String> plumages(List<Bird> birds) {
    return birds.stream().collect(Collectors.toMap(Bird::name, BirdClassifier::plumage));
  }

  public static Map<String, Integer> speeds(List<Bird> birds) {
    return birds.stream().collect(Collectors.toMap(Bird::name, BirdClassifier::airSpeedVelocity));
  }

  private static String plumage(Bird bird) {
    return switch (bird.type()) {
      case "유럽 제비" -> "보통이다";
      case "아프리카 제비" -> (bird.numberOfCoconuts() > 2) ? "지쳤다" : "보통이다";
      case "노르웨이 파랑 앵무" -> (bird.voltage() > 100) ? "그을렸다" : "예쁘다";
      default -> "알 수 없다";
    };
  }

  private static Integer airSpeedVelocity(Bird bird) {
    return switch (bird.type()) {
      case "유럽 제비" -> 35;
      case "아프리카 제비" -> 40 - 2 * bird.numberOfCoconuts();
      case "노르웨이 파랑 앵무" -> bird.isNailed() ? 0 : 10 + bird.voltage() / 10;
      default -> 0;
    };
  }
}
