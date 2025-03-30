package com.example.refactoring2.ch11.ex6;

public class HeatingPlan {
    private final int max;
    private final int min;
    private final Thermostat thermostat; // 온도 조절기

    public HeatingPlan(int max, int min, Thermostat thermostat) {
        this.max = max;
        this.min = min;
        this.thermostat = thermostat;
    }

    public int targetTemperature() {
        if (thermostat.selectedTemperature() > this.max) {
            return this.max;
        } else if (thermostat.selectedTemperature() < this.min) {
            return this.min;
        }

        return thermostat.selectedTemperature();
    }

}
