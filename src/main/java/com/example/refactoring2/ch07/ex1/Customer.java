package com.example.refactoring2.ch07.ex1;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Customer {
    private final String id;
    private final String name;
    private final Map<String, MonthlyUsage> usages;

    public Customer(Customer customer) {
        this(customer.id, customer.name, customer.usages);
    }

    public Customer(String id, String name, Map<String, MonthlyUsage> usages) {
        this.id = id;
        this.name = name;
        this.usages = new HashMap<>();

        for (Map.Entry<String, MonthlyUsage> entry : usages.entrySet()) {
            this.usages.put(entry.getKey(), new MonthlyUsage(entry.getValue()));
        }
    }

    public int usages(String year, String month) {
        MonthlyUsage monthlyUsage = getMonthlyUsage(year);
        return monthlyUsage.getAmount(month);
    }

    public void setUsage(String year, String month, int amount) {
        MonthlyUsage monthlyUsage = getMonthlyUsage(year);
        monthlyUsage.setUsage(month, amount);
    }

    private MonthlyUsage getMonthlyUsage(String year) {
        return  Optional.ofNullable(this.usages.get(year))
                .orElseThrow(() -> new IllegalArgumentException("MonthlyUsage not found:" + year));
    }
}
