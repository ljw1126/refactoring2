package com.example.refactoring2.ch11.ex6;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class HeatingPlanTest {

  @ParameterizedTest
  @CsvSource({
    "50, 30", "10, 20", "25, 25",
  })
  void targetTemperatureTest(int selectedTemperature, int expected) {
    Thermostat thermostat = new Thermostat(selectedTemperature, 0);
    HeatingPlan heatingPlan = new HeatingPlan(30, 20);

    int actual = heatingPlan.targetTemperature(thermostat.selectedTemperature());

    assertThat(actual).isEqualTo(expected);
  }
}
