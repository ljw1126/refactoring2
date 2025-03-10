package com.example.refactoring2.ch08.ex2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AccountTest {

  @Test
  void init() {
    AccountType accountType = new AccountType("청년희망적금", 3.14);

    Account account = new Account("123-4567", accountType);

    assertThat(account).isEqualTo(new Account("123-4567", accountType));
  }
}
