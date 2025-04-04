package com.example.refactoring2.ch12.ex6.part2;

import java.util.Objects;

public class Employee2 {
  private final String name;
  private final EmployeeType employeeType;

  public Employee2(String name, String type) {
    this(name, createEmployeeType(type));
  }

  public Employee2(String name, EmployeeType employeeType) {
    this.name = name;
    this.employeeType = employeeType;
  }

  public static EmployeeType createEmployeeType(String type) {
    return switch (type) {
      case "engineer" -> new Engineer();
      case "manager" -> new Manager();
      case "salesperson" -> new Salesperson();
      default -> throw new IllegalArgumentException("Invalid type " + type);
    };
  }

  public String capitalizedType() {
    char first = this.typeString().charAt(0);
    return Character.toUpperCase(first) + this.typeString().substring(1).toLowerCase();
  }

  public String toString() {
    return String.format("%s (%s)", this.name, this.typeString());
  }

  public EmployeeType getType() {
    return employeeType;
  }

  public String typeString() {
    return employeeType.toString();
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Employee2 employee2 = (Employee2) o;
    return Objects.equals(name, employee2.name)
        && Objects.equals(employeeType, employee2.employeeType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, employeeType);
  }
}
