package com.example.refactoring2.ch07.ex5;

import java.util.Objects;

public class TelephoneNumber {
    private String areaCode;
    private String number;

    public TelephoneNumber(String areaCode, String number) {
        this.areaCode = areaCode;
        this.number = number;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TelephoneNumber that = (TelephoneNumber) o;
        return Objects.equals(areaCode, that.areaCode) && Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(areaCode, number);
    }
}
