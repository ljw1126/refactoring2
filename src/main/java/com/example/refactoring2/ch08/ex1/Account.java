package com.example.refactoring2.ch08.ex1;

public class Account {
  private final int dayOverdrawn;
  private final AccountType type;

  public Account(int dayOverdrawn, AccountType type) {
    this.dayOverdrawn = dayOverdrawn;
    this.type = type;
  }

  // 은행 이자 계산
  public double bankCharge() {
    double result = 4.5;
    if (dayOverdrawn > 0) {
      result += type.overdraftCharge(dayOverdrawn);
    }
    return result;
  }
}
