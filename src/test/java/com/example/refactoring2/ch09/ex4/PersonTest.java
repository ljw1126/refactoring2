package com.example.refactoring2.ch09.ex4;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PersonTest {
  @Test
  void create() {
    TelephoneNumber telephoneNumber = new TelephoneNumber("A01", "123-456-7890");

    Person person = new Person(telephoneNumber);

    assertThat(person).isEqualTo(new Person(telephoneNumber));
  }
}
