package com.example.refactoring2.ch10.ex3;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PayrollCalculatorTest {

  @DisplayName("퇴사한 직원")
  @Test
  void separatedEmployeePayAmountTest() {
    Employee employee = new Employee(true, false);

    Payroll actual = PayrollCalculator.payAmount(employee);

    assertThat(actual).isEqualTo(new Payroll(0, ReasonCode.SEP));
  }

  @DisplayName("은퇴한 직원")
  @Test
  void retiredEmployeePayAmountTest() {
    Employee employee = new Employee(false, true);

    Payroll actual = PayrollCalculator.payAmount(employee);

    assertThat(actual).isEqualTo(new Payroll(0, ReasonCode.RET));
  }

  @DisplayName("일반 직원")
  @Test
  void EmployeePayAmountTest() {
    Employee employee = new Employee(false, false);

    Payroll actual = PayrollCalculator.payAmount(employee);

    assertThat(actual).isEqualTo(new Payroll(3_000_000, ReasonCode.BASIC));
  }

  @ParameterizedTest
  @CsvSource({
    "0, 1, 1, 1, 1, 0",
    "1, 0, 1, 1, 1, 0",
    "1, 1, 0, 1, 1, 0",
    "1, 1, 1, 10, 10, 100",
  })
  void adjustedCapitalTest(
      int capital, int interestRate, int duration, int income, int adjustmentFactor, int expected) {
    Instrument instrument =
        new Instrument(capital, interestRate, duration, income, adjustmentFactor);

    int actual = PayrollCalculator.adjustedCapital(instrument);

    assertThat(actual).isEqualTo(expected);
  }
}
