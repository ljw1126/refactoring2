package com.example.refactoring2.ch12.ex10.aSubclass;

import java.time.LocalDate;

public class PremiumBooking extends Booking {
    private final Extras extras; // 추가 비용

    public PremiumBooking(Show show, LocalDate date, boolean peakDay, Extras extras) {
        super(show, date, peakDay);
        this.extras = extras;
    }
    
    @Override
    public boolean hasTalkback() {
        return this.show.isTalkback();
    }

    @Override
    public long basePrice() {
        return Math.round(super.basePrice() + this.extras.premiumFee());
    }
}
