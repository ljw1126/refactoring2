package com.example.refactoring2.ch12.ex11;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class ScrollTest {

    @Test
    void needsCleaningTest() {
        LocalDate lastCleaned = LocalDate.of(2025, 1, 1);
        Scroll scroll = new Scroll(1L, "카탈로그 타이틀", Collections.EMPTY_SET, lastCleaned);

        boolean actual = scroll.needsCleaning(LocalDate.of(2025, 4, 5));

        assertThat(actual).isFalse();
    }

    @Test
    void dontNeedsCleaningTest() {
        LocalDate lastCleaned = LocalDate.of(2023, 1, 1);
        Scroll scroll = new Scroll(1L, "카탈로그 타이틀", Set.of("revered"), lastCleaned);

        boolean actual = scroll.needsCleaning(LocalDate.of(2025, 4, 5));

        assertThat(actual).isTrue();
    }
}