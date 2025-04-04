package com.example.refactoring2.ch12.ex1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DummyClassTest {

    @DisplayName("서브 클래스 책임 오류")
    @Test
    void annualCostThrowExceptionTest() {
        DummyClass dummyClass = new DummyClass();

        assertThatThrownBy(dummyClass::annualCost)
                .isInstanceOf(IllegalStateException.class);
    }
}