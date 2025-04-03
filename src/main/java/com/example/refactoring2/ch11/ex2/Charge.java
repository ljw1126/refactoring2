package com.example.refactoring2.ch11.ex2;

public class Charge {

  public String baseCharge(long usage) {
    if (usage < 0L) return usd(0.0);

    double amount =
        withinBand(usage, 0, 100) * 0.03
            + withinBand(usage, 100, 200) * 0.05
            + withinBand(usage, 200, Long.MAX_VALUE) * 0.07;

    return usd(amount);
  }

  private String usd(double value) {
    return value + " USD";
  }

  private long withinBand(long usage, long bottom, long top) {
    return usage > bottom ? Math.min(usage, top) - bottom : 0;
  }
}
