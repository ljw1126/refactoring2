package com.example.refactoring2.ch09.ex4;

import java.util.Objects;

public class TelephoneNumber {
  private final String areaCode;
  private final String number;

  public TelephoneNumber(String areaCode, String number) {
    this.areaCode = areaCode;
    this.number = number;
  }

  public String getAreaCode() {
    return areaCode;
  }

  public String getNumber() {
    return number;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    TelephoneNumber that = (TelephoneNumber) o;
    return Objects.equals(areaCode, that.areaCode) && Objects.equals(number, that.number);
  }

  @Override
  public int hashCode() {
    return Objects.hash(areaCode, number);
  }
}
