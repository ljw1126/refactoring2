package com.example.refactoring2.ch12.ex6;

import java.util.Objects;
import java.util.Set;

public class Employee {
  private static final Set<String> types = Set.of("engineer", "manager", "salesperson");

  private final String name;
  private final String type;

  public Employee(String name, String type) {
    validateType(type);
    this.name = name;
    this.type = type;
  }

  public void validateType(String type) {
    if (!types.contains(type)) {
      throw new IllegalArgumentException(type + "라는 직원 유형은 없습니다.");
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Employee employee = (Employee) o;
    return Objects.equals(name, employee.name) && Objects.equals(type, employee.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, type);
  }
}
