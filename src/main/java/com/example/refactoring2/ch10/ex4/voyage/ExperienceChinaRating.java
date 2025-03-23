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
  protected int voyageProfitFactor() {
    return super.voyageProfitFactor() + 3;
  }

  @Override
  protected int voyageLengthFactor() {
    int result = 0;

    if (voyage.length() > 12) result += 1;
    if (voyage.length() > 10) result -= 1;

    return result;
  }

  @Override
  protected int historyLengthFactor() {
    return (history.length() > 10) ? 1 : 0;
  }
}
