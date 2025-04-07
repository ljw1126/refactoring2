package com.example.refactoring2.ch12.ex7;

import java.util.List;
import java.util.stream.Stream;

public class PersonFactory {
  private PersonFactory() {}

  public static Person from(String name, String gender) {
    return switch (gender) {
      case "M" -> new Male(name, "M");
      case "F" -> new Female(name, "F");
      default -> new Person(name, "X");
    };
  }

  public static List<Person> loadFromInput(String[][] data) {
    return Stream.of(data).map(aRecord -> from(aRecord[0], aRecord[1])).toList();
  }
}
