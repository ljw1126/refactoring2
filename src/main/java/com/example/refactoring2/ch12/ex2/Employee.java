package com.example.refactoring2.ch12.ex2;

import java.util.Objects;

public class Employee extends Party {
    private final Long id;
    private final int monthlyCost;

    public Employee(Long id, String name, int monthlyCost) {
        super(name);
        this.id = id;
        this.monthlyCost = monthlyCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return monthlyCost == employee.monthlyCost && Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, monthlyCost);
    }
}
