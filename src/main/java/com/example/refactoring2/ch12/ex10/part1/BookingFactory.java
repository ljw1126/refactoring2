package com.example.refactoring2.ch12.ex10.part1;

import java.time.LocalDate;

public class BookingFactory {
  private BookingFactory() {}

  public static Booking createBooking(Show show, LocalDate date, boolean peakDay) {
    return new Booking(show, date, peakDay);
  }

  public static Booking createPremiumBooking(
      Show show, LocalDate date, boolean peakDay, Extras extras) {
    Booking result = new Booking(show, date, peakDay);
    result.bePremium(extras);
    return result;
  }
}
