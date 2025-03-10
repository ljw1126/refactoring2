package com.example.refactoring2.ch08.ex2;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

class CustomerTest {

  @Test
  void applyDiscountTest() {
    LocalDateTime now = LocalDateTime.now();
    Customer customer = new Customer("tester", 0.10, new CustomerContract(now));

    Amount amount = customer.applyDiscount(Amount.wons(10000));

    assertThat(amount).isEqualTo(Amount.wons(9000.0));
  }
}
