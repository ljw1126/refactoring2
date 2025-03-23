package com.example.refactoring2.ch10.ex4.voyage;

public class ExperienceChinaRating extends Rating {
  public ExperienceChinaRating(Voyage voyage, History history) {
    super(voyage, history);
  }

  @Override
  protected int captainHistoryRisk() {
    int result = super.captainHistoryRisk() - 2;
    return Math.max(result, 0);
  }

  @Override
  protected int voyageAndHistoryLengthFactor() {
    int result = 3;

    if (history.length() > 10) result += 1;
    if (voyage.length() > 12) result += 1;
    if (voyage.length() > 10) result -= 1;

    return result;
  }
}
