package com.example.refactoring2.ch12.ex1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EmployeeTest {
    @Test
    void annualCostTest() {
        Employee employee = new Employee(1000);

        int actual = employee.annualCost();

        assertThat(actual).isEqualTo(12_000);
    }
}