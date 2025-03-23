package com.example.refactoring2.ch10.ex4.voyage;

public class RatingUtils {
  private RatingUtils() {}

  public static String rating(Voyage voyage, History history) {
    return Rating.create(voyage, history).value();
  }
}
