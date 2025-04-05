package com.example.refactoring2.ch12.ex10.multiSubclass;

public class AfricanSwallowDelegate extends SpeciesDelegate {
    private final int numberOfCoconuts;

    public AfricanSwallowDelegate(BirdDto data, Bird bird) {
        super(bird);
        this.numberOfCoconuts = data.numberOfCoconuts();
    }

    @Override
    public Integer airSpeedVelocity() {
        return 40 - 2 * numberOfCoconuts;
    }
}
