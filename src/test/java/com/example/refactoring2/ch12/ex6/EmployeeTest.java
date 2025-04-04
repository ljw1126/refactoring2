package com.example.refactoring2.ch12.ex6;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class EmployeeTest {

  @ParameterizedTest
  @CsvSource({"engineer", "manager", "salesperson"})
  void validaTypeTest(String givenType) {
    Employee employee = Employee.of("tester", givenType);

    assertThat(employee).isEqualTo(Employee.of("tester", givenType));
  }

  @Test
  void invalidTypeThrowTest() {
    assertThatThrownBy(() -> Employee.of("tester", "invalid"))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
