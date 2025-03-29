package com.example.refactoring2.ch11.ex2;

public class Charge {

  public String baseCharge(long usage) {
    if (usage < 0L) return usd(0.0);

    double amount = bottomBand(usage) * 0.03 + middleBand(usage) * 0.05 + topBand(usage) * 0.07;

    return usd(amount);
  }

  private String usd(double value) {
    return value + " USD";
  }

  private long bottomBand(long usage) {
    return Math.min(usage, 100);
  }

  private long middleBand(long usage) {
    return usage > 100 ? Math.min(usage, 200) - 100 : 0;
  }

  private double topBand(long usage) {
    return (usage > 200) ? (usage - 200) : 0;
  }
}
