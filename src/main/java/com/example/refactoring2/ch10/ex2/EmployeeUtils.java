package com.example.refactoring2.ch10.ex2;

public class EmployeeUtils {

  private EmployeeUtils() {}

  // 장애 수당
  public static int disabilityAmount(Employee anEmployee) {
    return isNotEligibleForDisability(anEmployee) ? 0 : 10_000;
  }

  private static boolean isNotEligibleForDisability(Employee anEmployee) {
    return anEmployee.seniority() < 2 || anEmployee.monthsDisabled() > 12 || anEmployee.partTime();
  }

  public static double vacationAmount(Employee anEmployee) {
    return isEligibleForVacationAmount(anEmployee) ? 1 : 0.5;
  }

  private static boolean isEligibleForVacationAmount(Employee anEmployee) {
    return anEmployee.onVacation() && anEmployee.seniority() > 10;
  }
}
