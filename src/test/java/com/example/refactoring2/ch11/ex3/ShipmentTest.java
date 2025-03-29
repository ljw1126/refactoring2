package com.example.refactoring2.ch11.ex3;

import java.time.LocalDate;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ShipmentTest {

  @ParameterizedTest
  @CsvSource({
    "MA, 2025-04-03",
    "CT, 2025-04-03",
    "NY, 2025-04-04",
    "NH, 2025-04-04",
    "ME, 2025-04-05"
  })
  void deliveryDateTestWhenRushTrue(String deliveryState, String deliveryDate) {
    Shipment shipment = new Shipment(LocalDate.of(2025, 4, 1));

    Order order = new Order(deliveryState, LocalDate.parse("2025-04-01"));

    LocalDate actual = shipment.deliveryDate(order, true);

    Assertions.assertThat(actual).isEqualTo(LocalDate.parse(deliveryDate));
  }

  @ParameterizedTest
  @CsvSource({
    "MA, 2025-04-05",
    "CT, 2025-04-05",
    "NY, 2025-04-05",
    "NH, 2025-04-06",
    "ME, 2025-04-06",
    "NULL, 2025-04-07"
  })
  void deliveryDateTestWhenRushFalse(String deliveryState, String deliveryDate) {
    Shipment shipment = new Shipment(LocalDate.of(2025, 4, 1));

    Order order = new Order(deliveryState, LocalDate.parse("2025-04-01"));

    LocalDate actual = shipment.deliveryDate(order, false);

    Assertions.assertThat(actual).isEqualTo(LocalDate.parse(deliveryDate));
  }
}
