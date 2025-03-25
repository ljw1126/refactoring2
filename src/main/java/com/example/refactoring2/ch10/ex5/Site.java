package com.example.refactoring2.ch10.ex5;

public class Site {
  private final Customer customer;

  public Site(Customer customer) {
    this.customer = customer;
  }

  public Customer getCustomer() {
    return customer.getName().equals("미확인 고객") ? new UnknownCustomer() : this.customer;
  }
}
