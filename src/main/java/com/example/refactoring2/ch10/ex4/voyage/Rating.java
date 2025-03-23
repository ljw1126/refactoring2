package com.example.refactoring2.ch10.ex4.voyage;

import java.util.Set;

public class Rating {
  protected final Voyage voyage;
  protected final History history;

  public Rating(Voyage voyage, History history) {
    this.voyage = voyage;
    this.history = history;
  }

  public static Rating create(Voyage voyage, History history) {
    if (voyage.zone().equals("중국")
        && history.getZoneProfits().stream().anyMatch(p -> p.zone().equals("중국"))) {
      return new ExperienceChinaRating(voyage, history);
    }

    return new Rating(voyage, history);
  }

  public String value() {
    int vpf = voyageProfitFactor();
    int vr = voyageRisk();
    int chr = captainHistoryRisk();

    if (vpf * 3 > (vr + chr * 2)) return "A";

    return "B";
  }

  protected int voyageProfitFactor() {
    int result = 2;
    if (voyage.zone().equals("중국")) result += 1;
    if (voyage.zone().equals("동인도")) result += 1;

    result += voyageAndHistoryLengthFactor();

    return result;
  }

  protected int voyageAndHistoryLengthFactor() {
    int result = 0;

    if (history.length() > 0) result += 1;
    if (voyage.length() > 14) result -= 1;

    return result;
  }

  private int voyageRisk() {
    int result = 1;
    if (voyage.length() > 4) result += 2;
    if (voyage.length() > 0) result += (voyage.length() - 8);

    final Set<String> riskZone = Set.of("중국", "동인도");
    if (riskZone.contains(voyage.zone())) result += 4;

    return Math.max(result, 0);
  }

  protected int captainHistoryRisk() {
    int result = 1;
    if (history.length() < 5) result += 4;

    result += (int) history.getZoneProfits().stream().filter(v -> v.profit() < 0).count();

    return Math.max(result, 0);
  }
}
