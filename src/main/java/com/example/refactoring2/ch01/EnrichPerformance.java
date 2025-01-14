package com.example.refactoring2.ch01;

import com.example.refactoring2.ch01.calculator.PerformanceCalculator;

public class EnrichPerformance {
    private final String playId;
    private final int audience;
    private final Play play;
    private final int amount;
    private final int volumeCredits;

    public EnrichPerformance(String playId, int audience, Play play, int amount, int volumeCredits) {
        this.playId = playId;
        this.audience = audience;
        this.play = play;
        this.amount = amount;
        this.volumeCredits = volumeCredits;
    }

    public static EnrichPerformance create(Performance performance, Plays plays) throws Exception {
        String playId = performance.getPlayId();
        int audience = performance.getAudience();

        PerformanceCalculator calculator = PerformanceCalculator.create(performance, plays.get(playId));
        int amount = calculator.amount();
        int volumeCredits = calculator.volumeCredits();

        return new EnrichPerformance(playId,
                audience,
                calculator.getPlay(),
                amount,
                volumeCredits);
    }

    public int getAudience() {
        return audience;
    }

    public String getPlayName() {
        return play.getName();
    }

    public int getAmount() {
        return amount;
    }

    public int getVolumeCredits() {
        return volumeCredits;
    }
}
