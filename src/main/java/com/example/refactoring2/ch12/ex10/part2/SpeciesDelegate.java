package com.example.refactoring2.ch12.ex10.multiSubclass;

public class SpeciesDelegate {
    protected final Bird bird;

    protected SpeciesDelegate(Bird bird) {
        this.bird = bird;
    }

    public String plumage() {
        String plumage = this.bird.plumage();
        return plumage.isBlank() ? "보통이다" : plumage;
    }

    public Integer airSpeedVelocity() {
        return null;
    }
}
