package com.example.refactoring2.ch11.ex3;

import java.time.LocalDate;
import java.util.Set;

public class Shipment {
  private LocalDate deliveryDate;

  public Shipment(LocalDate deliveryDate) {
    this.deliveryDate = deliveryDate;
  }

  public LocalDate deliveryDate(Order anOrder, boolean isRush) {
    if (isRush) {
      int deliveryTime;
      if (Set.of("MA", "CT").contains(anOrder.deliverySate())) {
        deliveryTime = 1;
      } else if (Set.of("NY", "NH").contains(anOrder.deliverySate())) {
        deliveryTime = 2;
      } else {
        deliveryTime = 3;
      }

      return anOrder.placedOn().plusDays(1 + deliveryTime);
    }

    int deliveryTime;
    if (Set.of("MA", "CT", "NY").contains(anOrder.deliverySate())) {
      deliveryTime = 2;
    } else if (Set.of("ME", "NH").contains(anOrder.deliverySate())) {
      deliveryTime = 3;
    } else {
      deliveryTime = 4;
    }

    return anOrder.placedOn().plusDays(2 + deliveryTime);
  }
}
