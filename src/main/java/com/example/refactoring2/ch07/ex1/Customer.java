package com.example.refactoring2.ch07.ex1;

import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

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
        return usages.get(year).getAmount(month);
    }

    public void setUsage(String year, String month, int amount) {
        MonthlyUsage monthlyUsage = this.usages.get(year);

        Assert.notNull(monthlyUsage, "MonthlyUsage is null");

        monthlyUsage.setUsage(month, amount);
    }
}
