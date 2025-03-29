package com.example.refactoring2.ch11.ex2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SalaryManTest {

  @Test
  void tenPercentRaiseTest() {
    SalaryMan salaryMan = new SalaryMan(Salary.wons(1_000_000));

    salaryMan.raise(0.1);

    assertThat(salaryMan).isEqualTo(new SalaryMan(Salary.wons(1100000)));
  }

  @Test
  void fivePercentRaiseTest() {
    SalaryMan salaryMan = new SalaryMan(Salary.wons(1_000_000));

    salaryMan.raise(0.05);

    assertThat(salaryMan).isEqualTo(new SalaryMan(Salary.wons(1050000)));
  }
}
