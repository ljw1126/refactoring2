package com.example.refactoring2.ch08.ex1;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class AccountTypeTest {

  @ParameterizedTest
  @MethodSource("accountTypeProvider")
  void overdraftChargeTestWhenPremiumTrue(int dyaOverDrawn, double expected) {
    AccountType accountType = new AccountType(true);

    double actual = accountType.overdraftCharge(dyaOverDrawn);

    assertThat(actual).isEqualTo(expected);
  }

  private static Stream<Arguments> accountTypeProvider() {
    return Stream.of(Arguments.of(6, 10), Arguments.of(7, 10), Arguments.of(8, 10.85));
  }

  @Test
  void overdraftChargeTestWhenPremiumFalse() {
    AccountType accountType = new AccountType(false);

    double actual = accountType.overdraftCharge(5);

    assertThat(actual).isEqualTo(8.75);
  }
}
