package com.example.refactoring2.ch01;

import java.util.List;

public class Statement {

    private final Invoice invoice;
    private final Plays plays;

    public Statement(Invoice invoice, Plays plays) {
        this.invoice = invoice;
        this.plays = plays;
    }

    public String statement() throws Exception {
        List<EnrichPerformance> enrichPerformances = invoice.getPerformances().stream()
                .map(performance -> new EnrichPerformance(performance.getPlayId(), performance.getAudience(), playFor(performance.getPlayId())))
                .toList();
        StatementData data = new StatementData(invoice.getCustomer(), enrichPerformances);
        return renderPlainText(data);
    }

    private String renderPlainText(StatementData data) throws Exception {
        StringBuilder result = new StringBuilder();
        result.append(String.format("청구 내역 (고객명: %s)", data.getCustomer())).append("\n");

        for(EnrichPerformance performances : data.getEnrichPerformances()) {
            result.append(String.format("%s: $%d %d석\n", performances.getPlay().getName(), amountFor(performances) / 100, performances.getAudience()));
        }

        result.append(String.format("총액: $%d\n", totalAmount(data) / 100));
        result.append(String.format("적립 포인트: %d점\n", totalVolumeCredits(data)));
        return result.toString();
    }

    private int volumeCreditsFor(EnrichPerformance performance) {
        int result = 0;
        result += Math.max(performance.getAudience() - 30, 0);

        if(performance.getPlay().getType().equals(PlayType.COMEDY)) {
            result += (performance.getAudience() / 5);
        }

        return result;
    }

    private Play playFor(EnrichPerformance performances) {
        return plays.get(performances.getPlayId());
    }

    private Play playFor(String playId) {
        return plays.get(playId);
    }

    private int amountFor(EnrichPerformance performance) throws Exception {
        int result;
        switch (performance.getPlay().getType()) {
            case TRAGEDY :
                result = 40_000;
                if(performance.getAudience() > 30) {
                    result += 1_000 * (performance.getAudience() - 30);
                }
                break;
            case COMEDY :
                result = 30_000;
                if(performance.getAudience() > 30) {
                    result += 10_000 + 500 * (performance.getAudience() - 20);
                }
                result += 300 * performance.getAudience();
                break;
            default :
                throw new Exception(String.format("알 수 없는 장르: %s", performance.getPlay().getType()));
        }

        return result;
    }

    private int totalAmount(StatementData data) throws Exception {
        int result = 0;
        for(EnrichPerformance performances : data.getEnrichPerformances()) {
            result += amountFor(performances);
        }
        return result;
    }

    private int totalVolumeCredits(StatementData data) {
        int result = 0;
        for(EnrichPerformance performances : data.getEnrichPerformances()) {
            result += volumeCreditsFor(performances);
        }
        return result;
    }
}
