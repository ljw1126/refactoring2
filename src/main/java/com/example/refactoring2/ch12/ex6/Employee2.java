package com.example.refactoring2.ch12.ex6;

import java.util.Set;

public class Employee2 {
  private static final Set<String> types = Set.of("engineer", "manager", "salesperson");

  private final String name;
  private final String type;

  public Employee2(String name, String type) {
    validateType(type);
    this.name = name;
    this.type = type;
  }

  public void validateType(String type) {
    if (!types.contains(type)) {
      throw new IllegalArgumentException(type + "라는 직원 유형은 없습니다.");
    }
  }

  public String capitalizedType() {
    char first = type.charAt(0);
    return Character.toUpperCase(first) + type.substring(1).toLowerCase();
  }

  public String toString() {
    return String.format("%s (%s)", this.name, this.type);
  }
}
