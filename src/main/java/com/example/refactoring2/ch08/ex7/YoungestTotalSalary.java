package com.example.refactoring2.ch08.ex7;

import java.util.ArrayList;
import java.util.List;

public class YoungestTotalSalary {
  private final List<Person> peoples;

  public YoungestTotalSalary(List<Person> peoples) {
    this.peoples = new ArrayList<>(peoples);
  }

  public String getYoungestTotalSalary() {
    int youngest = peoples.isEmpty() ? Integer.MAX_VALUE : peoples.get(0).getAge();
    long totalSalary = 0;
    for (Person person : peoples) {
      if (person.getAge() < youngest) youngest = person.getAge();
      totalSalary += person.getSalary();
    }

    return String.format("최연소: %s, 총 급여: %s", youngest, totalSalary);
  }
}
