package com.example.refactoring2.ch07.ex3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PriorityTest {

    @Test
    void from() {
        Priority high = Priority.from("high");

        assertThat(high).isEqualTo(Priority.HIGH);
    }

    @Test
    void fromThrowException() {
        String given = "invalid";

        assertThatThrownBy(() -> Priority.from(given))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(given + "는 유효하지 않은 우선순위입니다");
    }

    @ParameterizedTest
    @CsvSource({
            "high, true",
            "rush, true",
            "normal, false"
    })
    void isHigher(String given, boolean expected) {
        Priority priority = Priority.from(given);

        assertThat(priority.isHigher()).isEqualTo(expected);
    }

    @Test
    void higherThan() {
        assertThat(Priority.HIGH.higherThan(Priority.NORMAL)).isTrue();
        assertThat(Priority.NORMAL.higherThan(Priority.HIGH)).isFalse();
        assertThat(Priority.RUSH.higherThan(Priority.HIGH)).isTrue();
    }

    @Test
    void lowerThan() {
        assertThat(Priority.NORMAL.lowerThan(Priority.HIGH)).isTrue();
        assertThat(Priority.HIGH.lowerThan(Priority.NORMAL)).isFalse();
        assertThat(Priority.RUSH.lowerThan(Priority.HIGH)).isFalse();
    }
}
