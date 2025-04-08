package com.example.refactoring2.ch12.ex6.part2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Employee2Test {

  @ParameterizedTest
  @CsvSource({"engineer", "manager", "salesperson"})
  void validaTypeTest(String givenType) {
    Employee2 employee = new Employee2("tester", givenType);

    assertThat(employee).isEqualTo(new Employee2("tester", givenType));
  }

  @Test
  void invalidTypeThrowTest() {
    assertThatThrownBy(() -> new Employee2("tester", "invalid"))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @ParameterizedTest
  @CsvSource({"engineer, Engineer", "manager, Manager", "salesperson, Salesperson"})
  void capitalizedTypeTest(String givenType, String expected) {
    Employee2 employee = new Employee2("tester", givenType);

    String actual = employee.capitalizedType();

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void createEngineerTest() {
    Employee2 employee = new Employee2("tester", "engineer");

    assertThat(employee).isEqualTo(new Employee2("tester", new Engineer()));
  }

  @Test
  void createManagerTest() {
    Employee2 employee = new Employee2("tester", "manager");

    assertThat(employee).isEqualTo(new Employee2("tester", new Manager()));
  }

  @Test
  void createSalespersonTest() {
    Employee2 employee = new Employee2("tester", "salesperson");

    assertThat(employee).isEqualTo(new Employee2("tester", new Salesperson()));
  }

  @Test
  void invalidEmployeeTypeThrowTest() {
    assertThatThrownBy(() -> new Employee2("tester", "invalid"))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
