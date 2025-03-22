package com.example.refactoring2.ch10.ex2;

public class EmployeeUtils {

  private EmployeeUtils() {}

  // 장애 수당
  public static int disabilityAmount(Employee anEmployee) {
    if (anEmployee.seniority() < 2) return 0;
    if (anEmployee.monthsDisabled() > 12) return 0;
    if (anEmployee.partTime()) return 0;

    return 10_000;
  }

  public static double vacationAmount(Employee anEmployee) {
    if (anEmployee.onVacation()) {
      if (anEmployee.seniority() > 10) {
        return 1;
      }
    }
    return 0.5;
  }
}
