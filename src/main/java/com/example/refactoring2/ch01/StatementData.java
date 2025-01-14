package com.example.refactoring2.ch01;

import java.util.ArrayList;
import java.util.List;

public class StatementData {
    private final String customer;
    private final List<EnrichPerformance> enrichPerformances;

    public StatementData(String customer, List<EnrichPerformance> enrichPerformances) {
        this.customer = customer;
        this.enrichPerformances = enrichPerformances;
    }

    public String getCustomer() {
        return customer;
    }

    public List<EnrichPerformance> getEnrichPerformances() {
        return enrichPerformances;
    }
}
