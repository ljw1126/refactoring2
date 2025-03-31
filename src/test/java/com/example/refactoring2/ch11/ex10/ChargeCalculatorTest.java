package com.example.refactoring2.ch11.ex10;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ChargeCalculatorTest {

  @Test
  void chargeTest() {
    Customer customer = new Customer(0.1);
    int usage = 1000;
    Provider provider = new Provider(100);

    ChargeCalculator chargeCalculator = new ChargeCalculator(customer, usage, provider);

    double actual = chargeCalculator.charge();

    assertThat(actual).isEqualTo(200.0);
  }
}
