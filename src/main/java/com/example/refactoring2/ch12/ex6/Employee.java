package com.example.refactoring2.ch12.ex6;

import java.util.Objects;

public class Employee {
  private final String name;

  public Employee(String name) {
    this.name = name;
  }

  public static Employee of(String name, String type) {
    return switch (type) {
      case "engineer" -> new Engineer(name);
      case "manager" -> new Manager(name);
      case "salesperson" -> new Salesperson(name);
      default -> throw new IllegalArgumentException(type + "라는 직원 유형은 없습니다");
    };
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
