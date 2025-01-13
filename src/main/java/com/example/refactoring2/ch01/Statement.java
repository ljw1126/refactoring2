package com.example.refactoring2.ch01;

public class Statement {

    private final Invoice invoice;
    private final Plays plays;

    public Statement(Invoice invoice, Plays plays) {
        this.invoice = invoice;
        this.plays = plays;
    }

    public String statement() throws Exception {
        int totalAmount = 0;
        int volumeCredits = 0;
        StringBuilder result = new StringBuilder();
        result.append(String.format("청구 내역 (고객명: %s)", invoice.getCustomer())).append("\n");

        for(Performance performances : invoice.getPerformances()) {
            volumeCredits += volumeCreditsFor(performances);

            result.append(String.format("%s: $%d %d석\n", playFor(performances).getName(), amountFor(performances) / 100, performances.getAudience()));
            totalAmount += amountFor(performances);
        }

        result.append(String.format("총액: $%d\n", totalAmount / 100));
        result.append(String.format("적립 포인트: %d점\n", volumeCredits));
        return result.toString();
    }

    private int volumeCreditsFor(Performance performances) {
        int result = 0;
        result += Math.max(performances.getAudience() - 30, 0);

        if(playFor(performances).getType().equals(PlayType.COMEDY)) {
            result += (performances.getAudience() / 5);
        }

        return result;
    }

    private Play playFor(Performance performances) {
        return plays.get(performances.getPlayId());
    }

    private int amountFor(Performance performance) throws Exception {
        int result;
        switch (playFor(performance).getType()) {
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
                throw new Exception(String.format("알 수 없는 장르: %s", playFor(performance).getType()));
        }

        return result;
    }
}
