package com.example.refactoring2.ch01;

import java.util.ArrayList;
import java.util.List;

public class Statement {

    private final Invoice invoice;
    private final Plays plays;

    public Statement(Invoice invoice, Plays plays) {
        this.invoice = invoice;
        this.plays = plays;
    }

    public String statement() throws Exception {
        List<EnrichPerformance> enrichPerformances = new ArrayList<>();
        for(Performance performance : invoice.getPerformances()) {
            enrichPerformances.add(create(performance, plays));
        }
        
        StatementData data = new StatementData(invoice.getCustomer(), enrichPerformances);
        return renderPlainText(data);
    }

    private EnrichPerformance create(Performance performance, Plays plays) throws Exception {
        String playId = performance.getPlayId();
        int audience = performance.getAudience();
        Play play = plays.get(playId);
        int amount = amountFor(performance, play);
        int volumeCredits = volumeCreditsFor(performance, play);

        return new EnrichPerformance(playId, audience, play, amount, volumeCredits);
    }

    private String renderPlainText(StatementData data) throws Exception {
        StringBuilder result = new StringBuilder();
        result.append(String.format("청구 내역 (고객명: %s)", data.getCustomer())).append("\n");

        for(EnrichPerformance performances : data.getEnrichPerformances()) {
            result.append(String.format("%s: $%d %d석\n", performances.getPlayName(), performances.getAmount() / 100, performances.getAudience()));
        }

        result.append(String.format("총액: $%d\n", totalAmount(data) / 100));
        result.append(String.format("적립 포인트: %d점\n", totalVolumeCredits(data)));
        return result.toString();
    }

    private int volumeCreditsFor(EnrichPerformance performance) {
        int result = 0;
        result += Math.max(performance.getAudience() - 30, 0);

        if(performance.getPlayType().equals(PlayType.COMEDY)) {
            result += (performance.getAudience() / 5);
        }

        return result;
    }

    private int volumeCreditsFor(Performance performance, Play play) {
        int result = 0;
        result += Math.max(performance.getAudience() - 30, 0);

        if(play.getType().equals(PlayType.COMEDY)) {
            result += (performance.getAudience() / 5);
        }

        return result;
    }

    private int amountFor(Performance performance, Play play) throws Exception {
        int result;
        switch (play.getType()) {
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
                throw new Exception(String.format("알 수 없는 장르: %s", play.getType()));
        }

        return result;
    }

    private int totalAmount(StatementData data) throws Exception {
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
