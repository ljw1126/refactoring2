package com.example.refactoring2.ch10.ex1;

import static org.assertj.core.api.Assertions.*;

import java.time.LocalDate;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ServiceChargeTest {

  @Test
  void chargeWhenSummerPeriodTest() {
    LocalDate summerStart = LocalDate.of(2025, 3, 1);
    LocalDate summerEnd = LocalDate.of(2025, 3, 31);
    double summerRate = 0.10;
    double regularRate = 1.0;
    int regularServiceCharge = 1_000;

    Plan plan = new Plan(summerStart, summerEnd, summerRate, regularRate, regularServiceCharge);
    ServiceCharge serviceCharge = new ServiceCharge(plan);

    double actual = serviceCharge.charge(10, LocalDate.of(2025, 3, 22));

    assertThat(actual).isEqualTo(1.0, Offset.offset(0.1));
  }

  @ParameterizedTest
  @CsvSource({"2, 28, 1010.0", "3, 1, 1.0", "3, 31, 1.0", "4, 1, 1010.0"})
  void chargeWhenNotSummerPeriodTest(int month, int day, double expected) {
    LocalDate summerStart = LocalDate.of(2025, 3, 1);
    LocalDate summerEnd = LocalDate.of(2025, 3, 31);
    double summerRate = 0.10;
    double regularRate = 1.0;
    int regularServiceCharge = 1_000;

    Plan plan = new Plan(summerStart, summerEnd, summerRate, regularRate, regularServiceCharge);
    ServiceCharge serviceCharge = new ServiceCharge(plan);

    double actual = serviceCharge.charge(10, LocalDate.of(2025, month, day));

    assertThat(actual).isEqualTo(expected, Offset.offset(0.1));
  }
}
