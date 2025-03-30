package com.example.refactoring2.ch11.ex6;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ClientTest {

    @DisplayName("HEAT 상태가 된다")
    @Test
    void controlTemperatureTest1() {
        Thermostat thermostat = new Thermostat(50, 0);
        HeatingPlan heatingPlan = new HeatingPlan(30, 20, thermostat); // selectedTemperature > max 이므로 max 반환

        Client client = new Client(heatingPlan, thermostat);

        client.controlTemperature();

        assertThat(client.getStatus()).isEqualTo(Client.AirConditionStatus.HEAT);
    }

    @DisplayName("COOL 상태가 된다")
    @Test
    void controlTemperatureTest2() {
        Thermostat thermostat = new Thermostat(10, 30);
        HeatingPlan heatingPlan = new HeatingPlan(30, 20, thermostat); // thermostat.selectedTemperature() < this.min 이므로 20 반환

        Client client = new Client(heatingPlan, thermostat);

        client.controlTemperature();

        assertThat(client.getStatus()).isEqualTo(Client.AirConditionStatus.COOL);
    }

    @DisplayName("OFF 상태가 된다")
    @Test
    void controlTemperatureTest3() {
        Thermostat thermostat = new Thermostat(25, 25);
        HeatingPlan heatingPlan = new HeatingPlan(30, 20, thermostat); // selectedTemperature 반환

        Client client = new Client(heatingPlan, thermostat);

        client.controlTemperature();

        assertThat(client.getStatus()).isEqualTo(Client.AirConditionStatus.OFF);
    }
}