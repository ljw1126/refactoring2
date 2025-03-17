package com.example.refactoring2.ch09.ex3;

public class Adjustment {
  private final int amount;

  public Adjustment(int amount) {
    this.amount = amount;
  }

  public int amount() {
    return amount;
  }
}
