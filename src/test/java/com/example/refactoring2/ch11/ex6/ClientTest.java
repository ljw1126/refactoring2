package com.example.refactoring2.ch11.ex6;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ClientTest {

  @DisplayName("HEAT 상태가 된다")
  @Test
  void controlTemperatureTest1() {
    HeatingPlan heatingPlan = new HeatingPlan(30, 20); // selectedTemperature > max 이므로 max 반환

    Thermostat thermostat = new Thermostat(50, 0);
    Client client = new Client(heatingPlan, thermostat);

    client.controlTemperature();

    assertThat(client.getStatus()).isEqualTo(Client.AirConditionStatus.HEAT);
  }

  @DisplayName("COOL 상태가 된다")
  @Test
  void controlTemperatureTest2() {
    HeatingPlan heatingPlan = new HeatingPlan(30, 20);

    Thermostat thermostat = new Thermostat(10, 30);
    Client client = new Client(heatingPlan, thermostat);

    client.controlTemperature();

    assertThat(client.getStatus()).isEqualTo(Client.AirConditionStatus.COOL);
  }

  @DisplayName("OFF 상태가 된다")
  @Test
  void controlTemperatureTest3() {
    HeatingPlan heatingPlan = new HeatingPlan(30, 20); // selectedTemperature 반환

    Thermostat thermostat = new Thermostat(25, 25);
    Client client = new Client(heatingPlan, thermostat);

    client.controlTemperature();

    assertThat(client.getStatus()).isEqualTo(Client.AirConditionStatus.OFF);
  }
}
