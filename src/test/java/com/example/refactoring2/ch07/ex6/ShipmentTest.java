package com.example.refactoring2.ch07.ex6;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ShipmentTest {

    @Test
    void display() {
        Shipment shipment = new Shipment(new TrackingInformation("대한통운", "9999"));

        assertThat(shipment.display())
                .isEqualTo("대한통운: 9999");
    }
}
