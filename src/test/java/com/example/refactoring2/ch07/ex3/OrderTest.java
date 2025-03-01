package com.example.refactoring2.ch07.ex3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class OrderTest {

    @Test
    void test() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(Priority.HIGH));
        orders.add(new Order(Priority.RUSH));
        orders.add(new Order(Priority.NORMAL));

        int highPriorityCount = (int) orders.stream()
                .filter(Order::isHigher)
                .count();

        assertThat(highPriorityCount).isEqualTo(2);
    }
}
