package com.example.refactoring2.ch12.ex7;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class PersonTest {

  @Test
  void createMaleTest() {
    Person person = PersonFactory.from("tester", "M");

    assertThat(person).isEqualTo(new Male("tester", "M"));
  }

  @Test
  void createFemaleTest() {
    Person person = PersonFactory.from("tester", "F");

    assertThat(person).isEqualTo(new Female("tester", "F"));
  }

  @Test
  void createPersonTest() {
    Person person = PersonFactory.from("tester", "X");

    assertThat(person).isEqualTo(new Person("tester", "X"));
  }

  @Test
  void loadFromInput() {
    String[][] data = {
      {"tester", "M"},
      {"tester", "F"},
      {"tester", "X"},
    };

    List<Person> actual = PersonFactory.loadFromInput(data);

    assertThat(actual)
        .containsExactly(
            new Male("tester", "M"), new Female("tester", "F"), new Person("tester", "X"));
  }

  @Test
  void isMaleTest() {
    Person person = PersonFactory.from("tester", "M");

    assertThat(person.isMale()).isTrue();
  }
}
