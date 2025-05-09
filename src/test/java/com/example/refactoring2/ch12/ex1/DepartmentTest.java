package com.example.refactoring2.ch12.ex1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DepartmentTest {

    @Test
    void annualCostTest() {
        Department department = new Department(1000);

        int actual = department.annualCost();

        assertThat(actual).isEqualTo(12_000);
    }
}