package com.example.refactoring2.ch08.ex2;

import java.util.Objects;

public class Account {
  private final String number;
  private final AccountType type;

  public Account(String number, AccountType type) {
    this.number = number;
    this.type = type;
  }

  public double interestRate() {
    return this.type.getInterestRate();
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Account account = (Account) o;
    return Objects.equals(number, account.number) && Objects.equals(type, account.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(number, type);
  }
}
