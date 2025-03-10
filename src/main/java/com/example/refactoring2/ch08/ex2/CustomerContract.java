package com.example.refactoring2.ch08.ex2;

import java.time.LocalDateTime;

public class CustomerContract {
  private final LocalDateTime startDate;

  public CustomerContract(LocalDateTime startDate) {
    this.startDate = startDate;
  }
}
