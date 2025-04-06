package com.example.refactoring2.ch12.ex3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EmployeeTest {

    @Test
    void create() {
        Employee employee = new Employee(1L, "tester", 100);

        assertThat(employee).isEqualTo(new Employee(1L, "tester", 100));
    }
}