package com.example.refactoring2.ch09.ex1;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

// 단위 테스트는 Chat-GPT 생성
class HaggisUtilsTest {

  @Test
  void testDistanceTravelled_SecondaryForceApplied() {
    Scenario scenario = new Scenario(10, 5, 3, 2);

    double result = HaggisUtils.distanceTravelled(scenario, 6);

    assertThat(result).isEqualTo(37.8);
  }

  @Test
  void testDistanceTravelled_ZeroTime() {
    Scenario scenario = new Scenario(10, 5, 3, 2);

    double result = HaggisUtils.distanceTravelled(scenario, 0);

    assertThat(result).isEqualTo(0);
  }

  @Test
  void testDistanceTravelled_MassIsZero() {
    Scenario scenario = new Scenario(10, 0, 3, 4);

    double result = HaggisUtils.distanceTravelled(scenario, 5);

    assertThat(Double.isInfinite(result)).isTrue();
  }
}
