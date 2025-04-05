package com.example.refactoring2.ch12.ex10.aSubclass;

public class Extras {

    private final long premiumFee;
    private final boolean dinner;

    public Extras(long premiumFee, boolean dinner) {
        this.premiumFee = premiumFee;
        this.dinner = dinner;
    }

    public long premiumFee() {
        return this.premiumFee;
    }

    public boolean hasDinner() {
        return this.dinner;
    }
}
