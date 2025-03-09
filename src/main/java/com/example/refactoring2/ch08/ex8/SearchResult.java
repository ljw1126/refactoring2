package com.example.refactoring2.ch08.ex8;

import java.util.Objects;

public class SearchResult {
  private final String city;
  private final String phone;

  public SearchResult(String city, String phone) {
    this.city = city;
    this.phone = phone;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    SearchResult that = (SearchResult) o;
    return Objects.equals(city, that.city) && Objects.equals(phone, that.phone);
  }

  @Override
  public int hashCode() {
    return Objects.hash(city, phone);
  }
}
