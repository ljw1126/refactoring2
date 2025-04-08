package com.example.refactoring2.ch12.ex6.part2;

public abstract class EmployeeType {
  @Override
  public boolean equals(Object obj) {
    return obj != null && this.getClass() == obj.getClass();
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
