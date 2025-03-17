package com.example.refactoring2.ch09.ex3;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AdjustmentTest {

  @Test
  void create() {
    Adjustment adjustment = new Adjustment(1);

    assertThat(adjustment.amount()).isEqualTo(1);
  }
}
