package com.example.refactoring2.ch01;

public class Statement {

    private final Invoice invoice;
    private final Plays plays;

    public Statement(Invoice invoice, Plays plays) {
        this.invoice = invoice;
        this.plays = plays;
    }

    public String statement() throws Exception {
        return renderPlainText(StatementData.createStatementData(invoice, plays));
    }

    private String renderPlainText(StatementData data) {
        StringBuilder result = new StringBuilder();
        result.append(String.format("청구 내역 (고객명: %s)", data.getCustomer())).append("\n");

        for(EnrichPerformance performances : data.getEnrichPerformances()) {
            result.append(String.format("%s: $%d %d석\n", performances.getPlayName(), performances.getAmount() / 100, performances.getAudience()));
        }

        result.append(String.format("총액: $%d\n", data.getTotalAmount() / 100));
        result.append(String.format("적립 포인트: %d점\n", data.getTotalVolumeCredits()));
        return result.toString();
    }

    private int totalAmount(StatementData data) {
        int result = 0;
        for(EnrichPerformance performances : data.getEnrichPerformances()) {
            result += performances.getAmount();
        }
        return result;
    }

    private int totalVolumeCredits(StatementData data) {
        int result = 0;
        for(EnrichPerformance performances : data.getEnrichPerformances()) {
            result += performances.getVolumeCredits();
        }
        return result;
    }
}
