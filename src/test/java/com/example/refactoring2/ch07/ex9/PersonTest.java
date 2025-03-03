package com.example.refactoring2.ch07.ex9;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PersonTest {

    @Test
    void foundPerson() {
        Person person = new Person();

        String actual = person.foundPerson(new String[]{"A", "B", "John"});

        assertThat(actual).isEqualTo("John");
    }
}
