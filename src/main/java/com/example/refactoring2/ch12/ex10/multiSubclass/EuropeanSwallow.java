package com.example.refactoring2.ch12.ex10.multiSubclass;

public class EuropeanSwallow extends Bird {

    public EuropeanSwallow(BirdDto data) {
        this(data.name(), data.plumage());
    }

    public EuropeanSwallow(String name, String plumage) {
        super(name, plumage);
    }

    @Override
    public Integer airSpeedVelocity() {
        return 35;
    }
}
