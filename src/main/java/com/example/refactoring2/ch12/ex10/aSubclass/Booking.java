package com.example.refactoring2.ch12.ex10.aSubclass;

import java.time.LocalDate;

public class Booking {
    protected final Show show;
    protected final LocalDate date;
    protected final boolean peakDay;

    protected Booking(Show show, LocalDate date, boolean peakDay) {
        this.show = show;
        this.date = date;
        this.peakDay = peakDay;
    }
    
    public boolean hasTalkback() {
        return this.show.isTalkback() && !peakDay;
    }

    public long basePrice() {
        long result = this.show.price();
        if (peakDay) {
            result += Math.round(result * 0.15);
        }
        return result;
    }
}
