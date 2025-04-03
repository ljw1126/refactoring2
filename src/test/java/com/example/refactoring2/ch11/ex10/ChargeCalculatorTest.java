package com.example.refactoring2.ch11.ex10;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ChargeCalculatorTest {

  @Test
  void chargeTest() {
    Customer customer = new Customer(0.1);
    int usage = 1000;
    Provider provider = new Provider(100);

    double actual = charge(customer, usage, provider);

    assertThat(actual).isEqualTo(200.0);
  }

  private double charge(Customer customer, int usage, Provider provider) {
    return new ChargeCalculator().charge(customer, usage, provider);
  }
}
