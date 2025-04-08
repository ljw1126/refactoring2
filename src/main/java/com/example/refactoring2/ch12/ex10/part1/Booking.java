package com.example.refactoring2.ch12.ex10.part1;

import java.time.LocalDate;

public class Booking {
  protected final Show show;
  protected final LocalDate date;
  protected final boolean peakDay;

  protected PremiumDelegate premiumDelegate;

  protected Booking(Show show, LocalDate date, boolean peakDay) {
    this.show = show;
    this.date = date;
    this.peakDay = peakDay;
  }

  protected void bePremium(Show show, boolean peakDay, Extras extras) {
    this.premiumDelegate = new PremiumDelegate(show, peakDay, extras);
  }

  public boolean hasTalkback() {
    return (this.premiumDelegate != null)
        ? this.premiumDelegate.hasTalkback()
        : this.show.talkback() && !peakDay;
  }

  public long basePrice() {
    long result = this.show.price();
    if (peakDay) result += Math.round(result * 0.15);

    return (this.premiumDelegate != null) ? this.premiumDelegate.extendBasePrice(result) : result;
  }

  public boolean hasDinner() {
    return (this.premiumDelegate != null) && this.premiumDelegate.hasDinner();
  }

  public Show getShow() {
    return show;
  }
}
