package com.example.refactoring2.ch09.ex3;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProductionPlanTest {

  @Test
  void create() {
    ProductionPlan plan = new ProductionPlan();

    assertThat(plan).isEqualTo(new ProductionPlan());
  }

  @Test
  void applyAdjustmentTest() {
    ProductionPlan plan = new ProductionPlan();
    plan.applyAdjustment(new Adjustment(1));

    assertThat(plan.getProduction()).isEqualTo(1);
  }
}
