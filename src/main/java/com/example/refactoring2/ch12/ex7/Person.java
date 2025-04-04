package com.example.refactoring2.ch12.ex7;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import org.springframework.util.StringUtils;

public class Person {
  private final String name;
  private final String genderCode;

  public Person(String name, String genderCode) {
    this.name = name;
    this.genderCode = StringUtils.hasLength(genderCode) ? genderCode : "X";
  }

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

  public String genderCode() {
    return this.genderCode;
  }

  public boolean isMale() {
    return this.genderCode.equals("M");
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Person person = (Person) o;
    return Objects.equals(name, person.name) && Objects.equals(genderCode, person.genderCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, genderCode);
  }
}
