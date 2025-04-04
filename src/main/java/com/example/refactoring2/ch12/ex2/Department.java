package com.example.refactoring2.ch12.ex2;

import java.util.Objects;

public class Department extends Party {
    private final String name;
    private final String staff;

    public Department(String name, String staff) {
        super();
        this.name = name;
        this.staff = staff;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(name, that.name) && Objects.equals(staff, that.staff);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, staff);
    }
}
