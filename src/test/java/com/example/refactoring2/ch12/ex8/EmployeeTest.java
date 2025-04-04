package com.example.refactoring2.ch12.ex8;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmployeeTest {

  @Test
  void employeeAnnualCost() {
    Employee employee = new Employee(1L, "tester", 10000);

    long actual = employee.annualCost();

    assertThat(actual).isEqualTo(120000);
  }
}
