package com.example.refactoring2.ch11.ex2;

import java.util.Objects;

public class SalaryMan {
  private Salary salary;

  public SalaryMan(Salary salary) {
    this.salary = salary;
  }

  public void tenPercentRaise() {
    this.salary = this.salary.multiply(1.1);
  }

  public void fivePercentRaise() {
    this.salary = this.salary.multiply(1.05);
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    SalaryMan salaryMan = (SalaryMan) o;
    return Objects.equals(salary, salaryMan.salary);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(salary);
  }
}
