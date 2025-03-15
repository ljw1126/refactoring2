package com.example.refactoring2.ch09.ex5;

import java.util.HashMap;
import java.util.Map;

public class RepositoryData {
  private final Map<Integer, Customer> customers;

  public RepositoryData() {
    this(new HashMap<>());
  }

  public RepositoryData(Map<Integer, Customer> customers) {
    this.customers = customers;
  }

  public Customer registerCustomer(Integer id) {
    if (!customers.containsKey(id)) {
      customers.put(id, new Customer(id));
    }

    return findCustomer(id);
  }

  public Customer findCustomer(Integer id) {
    return customers.get(id);
  }
}
