package com.example.refactoring2.ch12.ex7;

public class PersonFactory {
  private PersonFactory() {}

  public static Person from(String name, String gender) {
    return switch (gender) {
      case "M" -> new Male(name, "M");
      case "F" -> new Female(name, "F");
      default -> new Person(name, "X");
    };
  }
}
