package com.example.refactoring2.ch09.ex5;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OrderTest {

  @Test
  void create() {
    Order order = new Order(1, new Customer(2));

    assertThat(order).isEqualTo(new Order(1, new Customer(2)));
  }
}
