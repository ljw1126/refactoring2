package com.example.refactoring2.ch06.ex8;

public class Reading {
    private final int temp;
    private final String time;

    public Reading(int temp, String time) {
        this.temp = temp;
        this.time = time;
    }

    public int getTemp() {
        return temp;
    }

    public String getTime() {
        return time;
    }
}
