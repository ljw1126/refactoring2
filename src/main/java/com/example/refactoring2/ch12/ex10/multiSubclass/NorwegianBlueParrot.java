package com.example.refactoring2.ch12.ex10.multiSubclass;

public class NorwegianBlueParrot extends Bird {
    private final int voltage;
    private final boolean isNailed;
    
    public NorwegianBlueParrot(BirdDto data) {
        this(data.name(), data.plumage(), data.voltage(), data.isNailed());
    }

    public NorwegianBlueParrot(String name, String plumage, int voltage, boolean isNailed) {
        super(name, plumage);
        this.voltage = voltage;
        this.isNailed = isNailed;
    }

    @Override
    public String plumage() {
        if (voltage > 100) return "그을렸다";

        return this.plumage.isBlank() ? "예쁘다" : this.plumage;
    }

    @Override
    public Integer airSpeedVelocity() {
        return isNailed ? 0 : 10 + voltage / 10;
    }
}
