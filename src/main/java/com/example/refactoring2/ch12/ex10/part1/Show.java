package com.example.refactoring2.ch12.ex10.part1;

public class Show {
  private final long price;
  private final boolean talkback;

  public Show(long price, boolean talkback) {
    this.price = price;
    this.talkback = talkback;
  }

  public long price() {
    return this.price;
  }

  public boolean isTalkback() {
    return this.talkback;
  }
}
