package com.example.refactoring2.ch07.ex5;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PersonTest {


    @Test
    void init() {
        Person person = new Person("tester", new TelephoneNumber("051", "123-4567"));

        assertThat(person)
                .isEqualTo(new Person("tester", new TelephoneNumber("051", "123-4567")));
    }
}
