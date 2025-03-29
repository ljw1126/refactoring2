package com.example.refactoring2.ch11.ex3;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

public class Shipment {
  private LocalDate deliveryDate;

  public Shipment(LocalDate deliveryDate) {
    this.deliveryDate = deliveryDate;
  }

  private LocalDate regularDeliveryDate(Order anOrder) {
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

  private LocalDate rushDeliveryDate(Order anOrder) {
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

  public void setRushDeliveryDate(Order order) {
    this.deliveryDate = rushDeliveryDate(order);
  }

  public void setRegularDeliveryDate(Order order) {
    this.deliveryDate = regularDeliveryDate(order);
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Shipment shipment = (Shipment) o;
    return Objects.equals(deliveryDate, shipment.deliveryDate);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(deliveryDate);
  }
}
