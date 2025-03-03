package com.example.refactoring2.ch07.ex1;

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

    public void setName(String aString) {
        this.name = aString;
    }

    public void setCountry(String aCountryCode) {
        this.country = aCountryCode;
    }
}
