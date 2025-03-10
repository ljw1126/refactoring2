package com.example.refactoring2.ch08.ex7;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class YoungestTotalSalaryTest {

  @Test
  void getYoungestTotalSalaryTest() {
    List<Person> people =
        List.of(new Person(25, 50000), new Person(30, 60000), new Person(22, 70000));
    YoungestTotalSalary youngestTotalSalary = new YoungestTotalSalary(people);

    String actual = youngestTotalSalary.getYoungestTotalSalary();

    Assertions.assertThat(actual).isEqualTo("최연소: 22, 총 급여: 180000");
  }
}
