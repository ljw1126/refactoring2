package com.example.refactoring2.ch11.ex8;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EmployeeTest {

  @Test
  void leagelTypeCodeTest() {
    Employee employee = new Employee("tester", "E");

    Employee.LegalTypeCode type = employee.type();

    assertThat(type).isEqualTo(Employee.LegalTypeCode.ENGINEER);
  }

  @Test
  void notExistleagelTypeCodeTest() {
    Employee employee = new Employee("tester", "unknown");

    assertThatThrownBy(employee::type).isInstanceOf(IllegalArgumentException.class);
  }
}
