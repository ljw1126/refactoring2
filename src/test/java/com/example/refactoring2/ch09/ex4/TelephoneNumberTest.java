package com.example.refactoring2.ch09.ex4;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TelephoneNumberTest {

  @Test
  void create() {
    TelephoneNumber telephoneNumber = new TelephoneNumber("E01", "123456789");

    assertThat(telephoneNumber).isEqualTo(new TelephoneNumber("E01", "123456789"));
  }
}
