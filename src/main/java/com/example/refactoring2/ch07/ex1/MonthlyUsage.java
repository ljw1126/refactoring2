package com.example.refactoring2.ch07.ex1;

import java.util.HashMap;
import java.util.Map;

public class MonthlyUsage {
    private final Map<String, Integer> usageByMonth;

    public MonthlyUsage(MonthlyUsage monthlyUsage) {
        this(new HashMap<>(monthlyUsage.usageByMonth));
    }

    public MonthlyUsage(Map<String, Integer> usageByMonth) {
        this.usageByMonth = usageByMonth;
    }

    public int getAmount(String month) {
        return usageByMonth.getOrDefault(month, 0);
    }

    public void setUsage(String month, int amount) {
        usageByMonth.put(month, amount);
    }
}
