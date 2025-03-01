package com.example.refactoring2.ch07.ex7;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PersonTest {

    @Test
    void manager() {
        Person person = new Person("tester", new Person.Department("001", "toby"));

        String manager = person.getDepartment().getManager();

        assertThat(manager).isEqualTo("toby");
    }
}
