package com.example.refactoring2.ch08.ex2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AccountTypeTest {
  @Test
  void init() {
    AccountType accountType = new AccountType("예금", 5.5);

    assertThat(accountType).isEqualTo(new AccountType("예금", 5.5));
  }
}
