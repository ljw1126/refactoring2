package com.example.refactoring2.ch08.ex2;

import java.math.BigDecimal;
import java.util.Objects;

public class Amount {
  private final BigDecimal value;

  public Amount(BigDecimal value) {
    this.value = value;
  }

  public static Amount wons(long amount) {
    return new Amount(BigDecimal.valueOf(amount));
  }

  public static Amount wons(double amount) {
    return new Amount(BigDecimal.valueOf(amount));
  }

  public Amount multiply(double percent) {
    return new Amount(value.multiply(BigDecimal.valueOf(percent)));
  }

  public Amount subtract(Amount amount) {
    return new Amount(value.subtract(amount.value));
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Amount amount = (Amount) o;
    return Objects.equals(value, amount.value);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value);
  }
}
