package com.example.refactoring2.ch12.ex7;

public class Male extends Person {
  public Male(String name) {
    super(name);
  }

  @Override
  public String genderCode() {
    return "M";
  }
}
