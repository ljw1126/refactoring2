package com.example.refactoring2.ch08.ex2;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class AmountTest {

  @Test
  void init() {
    Amount amount = new Amount(BigDecimal.valueOf(1000L));

    assertThat(amount).isEqualTo(Amount.wons(1000L));
  }

  @Test
  void wonsTest() {
    Amount amount = new Amount(BigDecimal.valueOf(1000.1));

    assertThat(amount).isEqualTo(Amount.wons(1000.1));
  }

  @Test
  void multiplyTest() {
    Amount amount1 = Amount.wons(1000);

    Amount actual = amount1.multiply(2000);

    assertThat(actual).isEqualTo(Amount.wons(2_000_000.0));
  }

  @Test
  void subtractTest() {
    Amount amount1 = Amount.wons(1000);
    Amount amount2 = Amount.wons(10000);

    Amount actual = amount2.subtract(amount1);

    assertThat(actual).isEqualTo(Amount.wons(9000));
  }
}
