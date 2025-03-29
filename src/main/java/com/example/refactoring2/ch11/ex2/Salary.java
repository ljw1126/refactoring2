package com.example.refactoring2.ch11.ex2;

import java.math.BigDecimal;
import java.util.Objects;

public class Salary {
  private final BigDecimal amount;

  private Salary(BigDecimal amount) {
    this.amount = amount;
  }

  public static Salary wons(long amount) {
    return new Salary(halfUp(BigDecimal.valueOf(amount)));
  }

  public static Salary wons(double amount) {
    return new Salary(halfUp(BigDecimal.valueOf(amount)));
  }

  private static BigDecimal halfUp(BigDecimal amount) {
    return amount.setScale(2);
  }

  public Salary multiply(double percentage) {
    return new Salary(halfUp(this.amount.multiply(BigDecimal.valueOf(percentage))));
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Salary salary = (Salary) o;
    return Objects.equals(amount, salary.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(amount);
  }
}
