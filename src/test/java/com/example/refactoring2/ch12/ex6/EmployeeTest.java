package com.example.refactoring2.ch12.ex6;

import static com.example.refactoring2.ch12.ex6.EmployeeFactory.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class EmployeeTest {

  @ParameterizedTest
  @CsvSource({"engineer", "manager", "salesperson"})
  void validaTypeTest(String givenType) {
    Employee employee = of("tester", givenType);

    assertThat(employee).isEqualTo(of("tester", givenType));
  }

  @Test
  void invalidTypeThrowTest() {
    assertThatThrownBy(() -> of("tester", "invalid")).isInstanceOf(IllegalArgumentException.class);
  }
}
