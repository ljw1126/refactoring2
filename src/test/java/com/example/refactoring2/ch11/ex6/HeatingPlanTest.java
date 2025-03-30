package com.example.refactoring2.ch11.ex6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HeatingPlanTest {

    @DisplayName("온도조절기의 selectedTemperature가 HeatingPlan의 max를 초과하면 max를 반환한다")
    @Test
    void targetTemperatureTest1() {
        Thermostat thermostat = new Thermostat(50, 0);
        HeatingPlan heatingPlan = new HeatingPlan(30, 20, thermostat);

        int actual = heatingPlan.targetTemperature();

        assertThat(actual).isEqualTo(30);
    }

    @DisplayName("온도조절기의 selectedTemperature가 HeatingPlan의 min 미만이면 min을 반환한다")
    @Test
    void targetTemperatureTest2() {
        Thermostat thermostat = new Thermostat(10, 0);
        HeatingPlan heatingPlan = new HeatingPlan(30, 20, thermostat);

        int actual = heatingPlan.targetTemperature();

        assertThat(actual).isEqualTo(20);
    }

    @DisplayName("온도조절기의 selectedTemperature가 HeatingPlan의 max보다 작고, min보다 크면 selectedTemperature가 반환된다")
    @Test
    void targetTemperatureTest3() {
        Thermostat thermostat = new Thermostat(25, 0);
        HeatingPlan heatingPlan = new HeatingPlan(30, 20, thermostat);

        int actual = heatingPlan.targetTemperature();

        assertThat(actual).isEqualTo(25);
    }
}