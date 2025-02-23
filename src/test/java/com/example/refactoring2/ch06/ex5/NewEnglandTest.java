package com.example.refactoring2.ch06.ex5;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NewEnglandTest {

    @Test
    void inNewEngland() {
        Customer customer = new Customer(new Customer.Address(NewEngland.ME));

        boolean actual = NewEngland.inNewEngland(customer);

        assertThat(actual).isTrue();
    }
}