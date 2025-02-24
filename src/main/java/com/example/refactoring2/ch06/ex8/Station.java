package com.example.refactoring2.ch06.ex8;

import java.util.List;

public class Station {
    private final String name;
    private final List<Reading> readings;

    public Station(String name, List<Reading> readings) {
        this.name = name;
        this.readings = readings;
    }

    public String getName() {
        return name;
    }

    public List<Reading> getReadings() {
        return readings;
    }
}
