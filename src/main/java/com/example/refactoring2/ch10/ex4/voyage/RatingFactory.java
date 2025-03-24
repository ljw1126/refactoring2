package com.example.refactoring2.ch10.ex4.voyage;

public class RatingFactory {
  private RatingFactory() {}

  public static Rating create(Voyage voyage, History history) {
    if (voyage.zone().equals("중국")
        && history.getZoneProfits().stream().anyMatch(p -> p.zone().equals("중국"))) {
      return new ExperienceChinaRating(voyage, history);
    }

    return new Rating(voyage, history);
  }
}
