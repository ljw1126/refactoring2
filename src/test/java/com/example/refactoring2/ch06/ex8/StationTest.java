package com.example.refactoring2.ch06.ex8;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StationTest {

    @DisplayName("6.8 매개변수 객체 만들기")
    @Test
    void introduceParameterObjectTest() {
        List<Reading> readings = List.of(
                new Reading(47, "2016-11-10 09:10"),
                new Reading(53, "2016-11-10 09:20"),
                new Reading(58, "2016-11-10 09:30"),
                new Reading(53, "2016-11-10 09:40"),
                new Reading(51, "2016-11-10 09:50")
        );

        Station station = new Station("ZB1", readings);
        int temperatureFloor = 30;
        int temperatureCelling = 50;
        NumberRange range = new NumberRange(temperatureFloor, temperatureCelling);

        List<Reading> actual = station.readingsOutsideRange(range);

        assertThat(actual).hasSize(4);
    }
}
