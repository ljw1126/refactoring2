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
    return new Bird(bird).plumage();
  }

  private static Integer airSpeedVelocity(Bird bird) {
    return new Bird(bird).airSpeedVelocity();
  }
}
