package com.example.refactoring2.ch11.ex6;

public class Client {
    private final HeatingPlan thePlan;
    private final Thermostat thermostat; // 온도 조절기
    private AirConditionStatus status;

    public Client(HeatingPlan thePlan, Thermostat thermostat) {
        this.thePlan = thePlan;
        this.thermostat = thermostat;
        this.status = AirConditionStatus.DEFAULT;
    }

    public void controlTemperature() {
        if (thePlan.targetTemperature() > thermostat.currentTemperature()) {
            setToHeat();
        } else if (thePlan.targetTemperature() < thermostat.currentTemperature()) {
            setToCool();
        } else {
            setOff();
        }
    }

    public AirConditionStatus getStatus() {
        return status;
    }

    public enum AirConditionStatus {
        HEAT,
        COOL,
        OFF,
        DEFAULT;
    }

    private void setToCool() {
        this.status = AirConditionStatus.COOL;
    }

    private void setToHeat() {
        this.status = AirConditionStatus.HEAT;
    }

    private void setOff() {
        this.status = AirConditionStatus.OFF;
    }
}
