package com.example.refactoring2.ch12.ex10.aSubclass;

public class PremiumDelegate {
    private final Booking host;
    private final Extras extras;

    public PremiumDelegate(Booking host, Extras extras) {
        this.host = host;
        this.extras = extras;
    }

    public boolean hasTalkback() {
        Show show = this.host.getShow();
        return show.isTalkback();
    }

    public long extendBasePrice(long basePrice) {
        return basePrice + this.extras.premiumFee();
    }

    public boolean hasDinner() {
        return this.extras.hasDinner() && !this.host.peakDay;
    }
}
