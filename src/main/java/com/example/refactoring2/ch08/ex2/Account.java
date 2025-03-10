package com.example.refactoring2.ch08.ex2;

public class Account {
  private final String number;
  private final AccountType type;
  private final double interestRate;

  public Account(String number, AccountType type, double interestRate) {
    this.number = number;
    this.type = type;
    this.interestRate = interestRate;
  }
}
