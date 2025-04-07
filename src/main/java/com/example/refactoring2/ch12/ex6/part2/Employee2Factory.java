package com.example.refactoring2.ch12.ex6.part2;

public class Employee2Factory {
  private Employee2Factory() {}

  public static EmployeeType createEmployeeType(String type) {
    return switch (type) {
      case "engineer" -> new Engineer();
      case "manager" -> new Manager();
      case "salesperson" -> new Salesperson();
      default -> throw new IllegalArgumentException("Invalid type " + type);
    };
  }
}
