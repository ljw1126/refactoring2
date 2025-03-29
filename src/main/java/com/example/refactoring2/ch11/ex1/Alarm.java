package com.example.refactoring2.ch11.ex1;

public class Alarm {
  private boolean isOn;

  public Alarm() {
    this(true);
  }

  public Alarm(boolean isOn) {
    this.isOn = isOn;
  }

  public void setOffAlarms() {
    this.isOn = false;
  }

  public boolean isOn() {
    return isOn;
  }
}
