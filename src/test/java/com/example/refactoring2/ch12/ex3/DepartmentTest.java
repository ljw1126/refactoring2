package com.example.refactoring2.ch12.ex3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DepartmentTest {

    @Test
    void test() {
        Department department = new Department("name", "staff");

        assertThat(department).isEqualTo(new Department("name", "staff"));
    }
}