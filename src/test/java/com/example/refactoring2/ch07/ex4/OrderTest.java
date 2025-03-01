package com.example.refactoring2.ch07.ex4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrderTest {

    @Test
    void calculatePrice() {
        Order order = new Order(10, new Item(1000));

        double price = order.price();

        assertThat(price).isEqualTo(9500.0);
    }
}
