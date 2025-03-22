package com.example.refactoring2.ch10.ex3;

public class PayrollCalculator {

  private PayrollCalculator() {}

  public static Payroll payAmount(Employee employee) {
    if (employee.separated()) {
      return new Payroll(0, ReasonCode.SEP);
    }
    if (employee.retired()) {
      return new Payroll(0, ReasonCode.RET);
    }

    // 급여 계산 로직
    int money = 3_000_000;
    return new Payroll(money, ReasonCode.BASIC);
  }

  public static int adjustedCapital(Instrument anInstrument) {
    if (anInstrument.capital() <= 0
        || anInstrument.interestRate() <= 0
        || anInstrument.duration() <= 0) return 0;

    return (anInstrument.income() / anInstrument.duration()) * anInstrument.adjustmentFactor();
  }
}
