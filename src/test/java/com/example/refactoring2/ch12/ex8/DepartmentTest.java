package com.example.refactoring2.ch12.ex8;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DepartmentTest {
  @DisplayName("")
  @Test
  void departmentAnnualCostTest() {
    Department department = new Department("tester", List.of(1000, 2000, 3000));

    long actual = department.annualCost();

    assertThat(actual).isEqualTo(72_000);
  }
}
