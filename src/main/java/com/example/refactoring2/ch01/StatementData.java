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

    public static StatementData createStatementData(Invoice invoice, Plays plays) throws Exception {
        List<EnrichPerformance> enrichPerformances = new ArrayList<>();
        for(Performance performance : invoice.getPerformances()) {
            enrichPerformances.add(EnrichPerformance.create(performance, plays));
        }

        return new StatementData(invoice.getCustomer(), enrichPerformances);
    }

    public String getCustomer() {
        return customer;
    }

    public List<EnrichPerformance> getEnrichPerformances() {
        return enrichPerformances;
    }
}
