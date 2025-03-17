package com.example.refactoring2.ch09.ex5;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomerTest {

  @Test
  void create() {
    Customer customer = new Customer(1);

    assertThat(customer).isEqualTo(new Customer(1));
  }
}
