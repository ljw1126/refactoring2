package com.example.refactoring2.ch08.ex4;

import java.time.LocalDateTime;

public class Photo {
  private final String title;
  private final String location;
  private final LocalDateTime date;

  public Photo(String title, String location, LocalDateTime date) {
    this.title = title;
    this.location = location;
    this.date = date;
  }

  public String title() {
    return title;
  }

  public String location() {
    return location;
  }

  public LocalDateTime date() {
    return date;
  }
}
