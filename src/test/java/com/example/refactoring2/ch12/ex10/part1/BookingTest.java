package com.example.refactoring2.ch12.ex10.part1;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class BookingTest {

  @Test
  void basicBookingTest() {
    Show show = new Show(1000, false);
    LocalDate date = LocalDate.of(2025, 4, 5);
    Booking booking = Booking.createBooking(show, date, true);

    assertThat(booking.basePrice()).isEqualTo(1150L);
    assertThat(booking.hasDinner()).isFalse();
    assertThat(booking.hasTalkback()).isFalse();
  }

  @Test
  void premiumBookingTest() {
    Show show = new Show(1000, true);
    LocalDate date = LocalDate.of(2025, 4, 5);
    Extras extras = new Extras(500, false);
    Booking premiumBooking = Booking.createPremiumBooking(show, date, false, extras);

    assertThat(premiumBooking.basePrice()).isEqualTo(1500L);
    assertThat(premiumBooking.hasDinner()).isFalse();
    assertThat(premiumBooking.hasTalkback()).isTrue();
  }
}
