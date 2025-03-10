package com.example.refactoring2.ch08.ex6;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BillingServiceTest {

  @Test
  void processOrderTest() {
    PricingPlan pricingPlan = new PricingPlan(100, 10, 5, 0.1);
    Order order = new Order(10, false);
    BillingService billingService = new BillingService(() -> pricingPlan, (orderId) -> order);

    double actual = billingService.processOrder(9999L);

    assertThat(actual).isEqualTo(199.5);
  }
}
