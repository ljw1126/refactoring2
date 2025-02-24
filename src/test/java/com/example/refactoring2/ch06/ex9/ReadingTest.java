package com.example.refactoring2.ch06.ex9;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReadingTest {

    @DisplayName("6.9 여러 함수를 클래스로 묶기")
    @Test
    void combineFunctionIntoClassTest() {
        Reading reading = new Reading("ivan", 10, 5, 2017);
        int taxableCharge = reading.taxableChargeFn();
    }
}
