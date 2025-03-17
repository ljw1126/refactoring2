package com.example.refactoring2.ch09.ex4;

import java.util.Objects;

public class Person {
  private TelephoneNumber telephoneNumber;

  public Person(TelephoneNumber telephoneNumber) {
    this.telephoneNumber = telephoneNumber;
  }

  public String officeAreaCode() {
    return this.telephoneNumber.getAreaCode();
  }

  public void officeAreaCode(String arg) {
    this.telephoneNumber = new TelephoneNumber(arg, this.officeNumber());
  }

  public String officeNumber() {
    return this.telephoneNumber.getNumber();
  }

  public void officeNumber(String arg) {
    this.telephoneNumber = new TelephoneNumber(this.officeAreaCode(), arg);
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Person person = (Person) o;
    return Objects.equals(telephoneNumber, person.telephoneNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(telephoneNumber);
  }
}
