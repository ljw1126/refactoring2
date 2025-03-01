package com.example.refactoring2.ch07.ex3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class OrderTest {

    @Test
    void test() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(new Priority("high")));
        orders.add(new Order(new Priority("rush")));
        orders.add(new Order(new Priority("normal")));

        int highPriorityCount = (int) orders.stream()
                .map(Order::getPriorityString)
                .filter(p -> p.equals("high") || p.equals("rush"))
                .count();

        assertThat(highPriorityCount).isEqualTo(2);
    }
}
