package com.example.refactoring2.ch12.ex10.aSubclass;

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

    public static Booking createBooking(Show show, LocalDate date, boolean peakDay) {
        return new Booking(show, date, peakDay);
    }

    public static Booking createPremiumBooking(Show show, LocalDate date, boolean peakDay, Extras extras) {
        Booking result = new Booking(show, date, peakDay);
        result.bePremium(extras);
        return result;
    }

    protected void bePremium(Extras extras) {
        this.premiumDelegate = new PremiumDelegate(this, extras);
    }

    public boolean hasTalkback() {
        return (this.premiumDelegate != null)
                ? this.premiumDelegate.hasTalkback()
                : this.show.isTalkback() && !peakDay;
    }

    public long basePrice() {
        long result = this.show.price();
        if (peakDay) result += Math.round(result * 0.15);

        return (this.premiumDelegate != null)
                ? this.premiumDelegate.extendBasePrice(result)
                : result;
    }

    public boolean hasDinner() {
        return (this.premiumDelegate != null)
                && this.premiumDelegate.hasDinner();
    }

    public Show getShow() {
        return show;
    }
}
