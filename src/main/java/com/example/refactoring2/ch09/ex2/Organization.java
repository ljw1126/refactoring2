package com.example.refactoring2.ch09.ex2;

public class Organization {
  private String title;
  private String country;

  public Organization(String title, String country) {
    this.title = title;
    this.country = country;
  }

  public String getTitle() {
    return title;
  }

  public String getCountry() {
    return country;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setCountry(String country) {
    this.country = country;
  }
}
