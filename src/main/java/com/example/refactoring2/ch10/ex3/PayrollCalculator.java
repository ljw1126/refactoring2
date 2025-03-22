package com.example.refactoring2.ch10.ex3;

public class PayrollCalculator {

  private PayrollCalculator() {}

  public static Payroll payAmount(Employee employee) {
    Payroll result;
    if (employee.separated()) {
      result = new Payroll(0, ReasonCode.SEP);
    } else {
      if (employee.retired()) {
        result = new Payroll(0, ReasonCode.RET);
      } else {
        // 급여 계산 로직
        int money = 3_000_000;
        result = new Payroll(money, ReasonCode.BASIC);
      }
    }

    return result;
  }

  public static int adjustedCapital(Instrument anInstrument) {
    int result = 0;
    if (anInstrument.capital() > 0) {
      if (anInstrument.interestRate() > 0 && anInstrument.duration() > 0) {
        result =
            (anInstrument.income() / anInstrument.duration()) * anInstrument.adjustmentFactor();
      }
    }

    return result;
  }
}
