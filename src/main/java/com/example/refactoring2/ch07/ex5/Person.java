package com.example.refactoring2.ch07.ex5;

import java.util.Objects;

public class Person {
    private String name;
    private TelephoneNumber telephoneNumber;

    public Person(String name, TelephoneNumber telephoneNumber) {
        this.name = name;
        this.telephoneNumber = telephoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAreaCode() {
        return telephoneNumber.getAreaCode();
    }

    public void setAreaCode(String officeAreaCode) {
        telephoneNumber.setAreaCode(officeAreaCode);
    }

    public String getNumber() {
        return telephoneNumber.getNumber();
    }

    public void setNumber(String officeNumber) {
        telephoneNumber.setNumber(officeNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(telephoneNumber, person.telephoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, telephoneNumber);
    }
}
