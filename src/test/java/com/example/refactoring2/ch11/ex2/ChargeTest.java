package com.example.refactoring2.ch11.ex2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

// create by Chat-GPT
class ChargeTest {

  private final Charge charge = new Charge();

  @Test
  void testBaseChargeWithZeroUsage() {
    // 0 사용량에 대해 요금은 0이어야 함
    String actual = charge.baseCharge(0L);

    assertThat(actual).isEqualTo("0.0 USD");
  }

  @Test
  void testBaseChargeWithBelowThresholdUsage() {
    // 50 사용량에 대해 요금 계산 (하위 100 단위)
    String actual = charge.baseCharge(50L);

    // 예상 금액: 50 * 0.03 = 1.50 USD
    assertThat(actual).isEqualTo("1.5 USD");
  }

  @Test
  void testBaseChargeWithMixedUsage() {
    // 150 사용량에 대해 요금 계산 (하위 100 + 중간 50 단위)
    String actual = charge.baseCharge(150L);

    // 예상 금액: 100 * 0.03 + 50 * 0.05 = 3.00 + 2.50 = 5.50 USD
    assertThat(actual).isEqualTo("5.5 USD");
  }

  @Test
  void testBaseChargeWithHighUsage() {
    // 250 사용량에 대해 요금 계산 (하위 100 + 중간 100 + 상위 50 단위)
    String actual = charge.baseCharge(250L);

    // 예상 금액: 100 * 0.03 + 100 * 0.05 + 50 * 0.07 = 3.00 + 5.00 + 3.50 = 11.50 USD
    assertThat(actual).isEqualTo("11.5 USD");
  }

  @Test
  void testBaseChargeWithNegativeUsage() {
    // 음수 사용량은 0으로 처리되어야 함
    String actual = charge.baseCharge(-50L);

    assertThat(actual).isEqualTo("0.0 USD");
  }
}
