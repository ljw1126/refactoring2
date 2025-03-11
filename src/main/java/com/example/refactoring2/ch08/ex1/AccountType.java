package com.example.refactoring2.ch08.ex1;

public class AccountType {
  private final boolean premium;

  public AccountType(boolean premium) {
    this.premium = premium;
  }

  private boolean isPremium() {
    return premium;
  }

  // 초과 인출 이자 계산
  public double overdraftCharge(int dayOverdrawn) {
    if (isPremium()) {
      int baseCharge = 10;
      if (dayOverdrawn <= 7) {
        return baseCharge;
      }

      return baseCharge + (dayOverdrawn - 7) * 0.85;
    }

    return dayOverdrawn * 1.75;
  }
}
