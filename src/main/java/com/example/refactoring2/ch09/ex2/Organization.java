package com.example.refactoring2.ch09.ex2;

public class Organization {
  private String name;
  private String country;

  public Organization(String name, String country) {
    this.name = name;
    this.country = country;
  }

  public String getName() {
    return name;
  }

  public String getCountry() {
    return country;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setCountry(String country) {
    this.country = country;
  }
}
