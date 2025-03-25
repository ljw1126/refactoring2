package com.example.refactoring2.ch10.ex6;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomerTest {

  @Test
  void applyDiscountTestWhenDiscountRateIsZero() {
    Customer customer = new Customer(0.0);

    double actual = customer.applyDiscount(10);

    assertThat(actual).isEqualTo(10.0);
  }

  @Test
  void applyDiscountTestWhenDiscountRateGreaterThanZero() {
    Customer customer = new Customer(0.1);

    double actual = customer.applyDiscount(10);

    assertThat(actual).isEqualTo(9.0);
  }

  @Test
  void throwExceptionWhenDiscountRateIsNegative() {
    assertThatThrownBy(() -> new Customer(-0.1)).isInstanceOf(IllegalArgumentException.class);
  }
}
