package com.example.refactoring2.ch09.ex5;

import java.util.Objects;

public class Order {
  private final int number;
  private final Customer customer;

  public Order(int number, int customerId, RepositoryData repository) {
    this.number = number;
    this.customer = repository.registerCustomer(customerId); // 참조를 가져옴
  }

  public Customer getCustomer() {
    return customer;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Order order = (Order) o;
    return number == order.number && Objects.equals(customer, order.customer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(number, customer);
  }
}
