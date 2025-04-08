package com.example.refactoring2.ch12.ex6;

import java.util.Objects;

public class Employee {
  private final String name;

  public Employee(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Employee employee = (Employee) o;
    return Objects.equals(name, employee.name);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(name);
  }
}
