package com.example.refactoring2.ch06.ex3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrderTest {

    @Test
    void price() {
        Order order = new Order(10, 1000);

        double actual = order.price();

        assertThat(actual).isEqualTo(10100.0);
    }
}
