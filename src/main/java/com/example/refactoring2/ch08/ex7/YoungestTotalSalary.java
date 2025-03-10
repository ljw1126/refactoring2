package com.example.refactoring2.ch08.ex7;

import java.util.ArrayList;
import java.util.List;

public class YoungestTotalSalary {
  private final List<Person> peoples;

  public YoungestTotalSalary(List<Person> peoples) {
    this.peoples = new ArrayList<>(peoples);
  }

  public String getYoungestTotalSalary() {
    return String.format("최연소: %s, 총 급여: %s", youngest(), totalSalary());
  }

  private int youngest() {
    return peoples.stream()
        .mapToInt(Person::getAge)
        .min()
        .orElseThrow(() -> new IllegalArgumentException("No people available"));
  }

  private long totalSalary() {
    return peoples.stream().mapToInt(Person::getSalary).sum();
  }
}
