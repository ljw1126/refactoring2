package com.example.refactoring2.ch12.ex2;

import java.util.Objects;

public class Employee extends Party {
    private final Long id;
    private final String name;
    private final int monthlyCost;

    public Employee(Long id, String name, int monthlyCost) {
        super();
        this.id = id;
        this.name = name;
        this.monthlyCost = monthlyCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return monthlyCost == employee.monthlyCost && Objects.equals(id, employee.id) && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, monthlyCost);
    }
}
