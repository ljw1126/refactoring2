package com.example.refactoring2.ch10.ex5;

public class PaymentHistory {
  private final int weeksDelinquentInLastYear;

  public PaymentHistory(int weeksDelinquentInLastYear) {
    this.weeksDelinquentInLastYear = weeksDelinquentInLastYear;
  }

  public int getWeeksDelinquentInLastYear() {
    return weeksDelinquentInLastYear;
  }
}
