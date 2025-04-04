package com.example.refactoring2.ch12.ex6;

public class EmployeeType {
  private final String value;

  public EmployeeType(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return this.value;
  }
}
