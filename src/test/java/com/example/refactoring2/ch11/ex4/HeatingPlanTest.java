package com.example.refactoring2.ch11.ex4;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HeatingPlanTest {

  @DisplayName("방 온도가 HeatingPlan의 지정 범위이다")
  @Test
  void withinRangeTest() {
    Room room = new Room(new TemperatureRange(10, 20));
    int low = room.daysTempRange().low();
    int high = room.daysTempRange().high();

    HeatingPlan aPlan = new HeatingPlan(new TemperatureRange(5, 25));

    assertThat(aPlan.withinRange(low, high)).isTrue();
  }

  @DisplayName("방 온도가 HeatingPlan의 지정 범위를 벗어났다")
  @Test
  void withinRangeTestWhenOverRange() {
    Room room = new Room(new TemperatureRange(1, 30));
    int low = room.daysTempRange().low();
    int high = room.daysTempRange().high();

    HeatingPlan aPlan = new HeatingPlan(new TemperatureRange(5, 25));

    assertThat(aPlan.withinRange(low, high)).isFalse();
  }
}
