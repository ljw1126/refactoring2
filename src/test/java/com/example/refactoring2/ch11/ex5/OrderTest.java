package com.example.refactoring2.ch11.ex5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrderTest {

    @DisplayName("quantity가 100 초과이므로 기본 가격에 0.9가 곱해진다")
    @Test
    void finalPriceTest1() {
        Order order = new Order(101, 1000);

        double actual = order.finalPrice();
        double expected = 1000 * 101 * 0.9;

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("quantity가 100 이하이므로 기본 가격에 0.95가 곱해진다")
    @Test
    void finalPriceTest2() {
        Order order = new Order(100, 1000);

        double actual = order.finalPrice();
        double expected = 1000 * 100 * 0.95;

        assertThat(actual).isEqualTo(expected);
    }
}