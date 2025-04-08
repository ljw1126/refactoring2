package com.example.refactoring2.ch12.ex10.part1;

public class PremiumDelegate {
  private final Extras extras;
  private final Show show;
  private final boolean peakDay;

  public PremiumDelegate(Show show, boolean peakDay, Extras extras) {
    this.extras = extras;
    this.show = show;
    this.peakDay = peakDay;
  }

  public boolean hasTalkback() {
    return show.talkback();
  }

  public long extendBasePrice(long basePrice) {
    return basePrice + this.extras.premiumFee();
  }

  public boolean hasDinner() {
    return this.extras.hasDinner() && !this.peakDay;
  }
}
