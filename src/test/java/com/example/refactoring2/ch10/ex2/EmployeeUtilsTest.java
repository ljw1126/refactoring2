package com.example.refactoring2.ch10.ex2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class EmployeeUtilsTest {

  @DisplayName("장애 수당 경계값 테스트")
  @ParameterizedTest
  @CsvSource({
    "1, 13, false, false, 0",
    "3, 13, false, false, 0",
    "3, 12, true, false, 0",
    "2, 12, false, false, 10000"
  })
  void boundaryValueTest(
      int seniority, int monthsDisabled, boolean partTime, boolean onVacation, int expected) {
    Employee employee = new Employee(seniority, monthsDisabled, partTime, onVacation);

    int actual = EmployeeUtils.disabilityAmount(employee);

    assertThat(actual).isEqualTo(expected);
  }

  @DisplayName("vacationAmount 경계값 테스트")
  @ParameterizedTest
  @CsvSource({"0, 0, false, false, 0.5", "10, 0, false, true, 0.5", "11, 0, false, true, 1"})
  void boundaryValueTestForVacationAmount(
      int seniority, int monthsDisabled, boolean partTime, boolean onVacation, double expected) {
    Employee employee = new Employee(seniority, monthsDisabled, partTime, onVacation);

    double actual = EmployeeUtils.vacationAmount(employee);

    assertThat(actual).isEqualTo(expected);
  }
}
