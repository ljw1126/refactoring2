package com.example.refactoring2.ch01;

import java.util.ArrayList;
import java.util.List;

public class StatementData {
    private final String customer;
    private final List<EnrichPerformance> enrichPerformances;
    private final int totalAmount;
    private final int totalVolumeCredits;

    private StatementData(String customer, List<EnrichPerformance> enrichPerformances) {
        this.customer = customer;
        this.enrichPerformances = enrichPerformances;
        this.totalAmount = totalAmount();
        this.totalVolumeCredits = totalVolumeCredits();
    }

    public static StatementData create(Invoice invoice, Plays plays) {
        List<EnrichPerformance> enrichPerformances = new ArrayList<>();
        for(Performance performance : invoice.getPerformances()) {
            enrichPerformances.add(EnrichPerformance.create(performance, plays));
        }

        return new StatementData(invoice.getCustomer(), enrichPerformances);
    }

    private int totalAmount() {
        return enrichPerformances.stream()
                .mapToInt(EnrichPerformance::getAmount)
                .sum();
    }

    private int totalVolumeCredits() {
        return enrichPerformances.stream()
                .mapToInt(EnrichPerformance::getVolumeCredits)
                .sum();
    }

    public String getCustomer() {
        return customer;
    }

    public List<EnrichPerformance> getEnrichPerformances() {
        return enrichPerformances;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public int getTotalVolumeCredits() {
        return totalVolumeCredits;
    }
}
