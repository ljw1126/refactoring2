package com.example.refactoring2.ch10.ex5;

public class NullPaymentHistory extends PaymentHistory {

  public NullPaymentHistory() {
    this(0);
  }

  public NullPaymentHistory(int weeksDelinquentInLastYear) {
    super(weeksDelinquentInLastYear);
  }
}
