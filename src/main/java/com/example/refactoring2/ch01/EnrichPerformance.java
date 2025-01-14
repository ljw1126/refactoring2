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

        Play play = plays.get(playId);
        PerformanceCalculator calculator = new PerformanceCalculator(performance, play);
        int amount = calculator.amount();
        int volumeCredits = calculator.volumeCredits();

        return new EnrichPerformance(playId, audience, play, amount, volumeCredits);
    }

    private static int volumeCreditsFor(Performance performance, Play play) {
        return new PerformanceCalculator(performance, play).volumeCredits();
    }

    private static int amountFor(Performance performance, Play play) throws Exception {
        return new PerformanceCalculator(performance, play).amount();
    }

    public String getPlayId() {
        return playId;
    }

    public int getAudience() {
        return audience;
    }

    public Play getPlay() {
        return play;
    }

    public String getPlayName() {
        return play.getName();
    }

    public PlayType getPlayType() {
        return play.getType();
    }

    public int getAmount() {
        return amount;
    }

    public int getVolumeCredits() {
        return volumeCredits;
    }
}
