package com.example.refactoring2.ch09.ex1;

public class Scenario {
  private double primaryForce;
  private double mass;
  private int delay;
  private double secondaryForce;

  public Scenario(double primaryForce, double mass, int delay, double secondaryForce) {
    this.primaryForce = primaryForce;
    this.mass = mass;
    this.delay = delay;
    this.secondaryForce = secondaryForce;
  }

  public double primaryForce() {
    return this.primaryForce;
  }

  public double mass() {
    return this.mass;
  }

  public int delay() {
    return this.delay;
  }

  public double secondaryForce() {
    return this.secondaryForce;
  }
}
