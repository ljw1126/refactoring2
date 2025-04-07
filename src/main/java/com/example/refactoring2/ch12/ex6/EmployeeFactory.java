package com.example.refactoring2.ch12.ex6;

public class EmployeeFactory {
  private EmployeeFactory() {}

  public static Employee of(String name, String type) {
    return switch (type) {
      case "engineer" -> new Engineer(name);
      case "manager" -> new Manager(name);
      case "salesperson" -> new Salesperson(name);
      default -> throw new IllegalArgumentException(type + "라는 직원 유형은 없습니다");
    };
  }
}
