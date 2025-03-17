package com.example.refactoring2.ch09.ex5;

import java.util.Objects;

public class Customer {
  private final int id;

  public Customer(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Customer customer = (Customer) o;
    return id == customer.id;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }
}
