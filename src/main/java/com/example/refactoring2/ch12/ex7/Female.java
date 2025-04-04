package com.example.refactoring2.ch12.ex7;

public class Female extends Person {
  public Female(String name) {
    super(name);
  }

  @Override
  public String genderCode() {
    return "F";
  }
}
