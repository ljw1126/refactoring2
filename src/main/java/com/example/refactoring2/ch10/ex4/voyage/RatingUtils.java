package com.example.refactoring2.ch10.ex4.voyage;

import java.util.Set;

public class RatingUtils {
  private RatingUtils() {}

  public static String rating(Voyage voyage, History history) {
    int vpf = voyageProfitFactor(voyage, history);
    int vr = voyageRisk(voyage);
    int chr = captainHistoryRisk(voyage, history);

    if (vpf * 3 > (vr + chr * 2)) return "A";

    return "B";
  }

  private static int voyageProfitFactor(Voyage voyage, History history) {
    int result = 2;
    if (voyage.zone().equals("중국")) result += 1;
    if (voyage.zone().equals("동인도")) result += 1;
    if (voyage.zone().equals("중국") && hasChain(history)) {
      result += 3;
      if (history.length() > 10) result += 1;
      if (voyage.length() > 12) result += 1;
      if (voyage.length() > 10) result -= 1;
    } else {
      if (history.length() > 0) result += 1;
      if (voyage.length() > 14) result -= 1;
    }

    return result;
  }

  private static int voyageRisk(Voyage voyage) {
    int result = 1;
    if (voyage.length() > 4) result += 2;
    if (voyage.length() > 0) result += (voyage.length() - 8);

    final Set<String> riskZone = Set.of("중국", "동인도");
    if (riskZone.contains(voyage.zone())) result += 4;

    return Math.max(result, 0);
  }

  private static int captainHistoryRisk(Voyage voyage, History history) {
    int result = 1;
    if (history.length() < 5) result += 4;

    result += (int) history.getZoneProfits().stream().filter(v -> v.profit() < 0).count();

    if (voyage.zone().equals("중국") && hasChain(history)) result -= 2;

    return Math.max(result, 0);
  }

  private static boolean hasChain(History history) {
    return history.getZoneProfits().stream().anyMatch(v -> v.zone().equals("중국"));
  }
}
