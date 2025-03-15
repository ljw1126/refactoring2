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

  @Test
  void updateOfficeAreaCodeTest() {
    TelephoneNumber telephoneNumber = new TelephoneNumber("A01", "123-456-7890");
    Person person = new Person(telephoneNumber);

    person.officeAreaCode("B01");

    assertThat(person).isEqualTo(new Person(new TelephoneNumber("B01", "123-456-7890")));
  }

  @Test
  void updateOfficeNumberTest() {
    TelephoneNumber telephoneNumber = new TelephoneNumber("A01", "123-456-7890");
    Person person = new Person(telephoneNumber);

    person.officeNumber("999-999-9999");

    assertThat(person).isEqualTo(new Person(new TelephoneNumber("A01", "999-999-9999")));
  }
}
