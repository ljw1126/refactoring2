package com.example.refactoring2.ch12.ex10.part2;

public class SpeciesDelegate {

  public String plumage(String value) {
    return value.isBlank() ? "보통이다" : value;
  }

  public Integer airSpeedVelocity() {
    return null;
  }
}
