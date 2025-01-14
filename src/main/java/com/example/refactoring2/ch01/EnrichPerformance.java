package com.example.refactoring2.ch01;

public class EnrichPerformance {
    private final String playId;
    private final int audience;
    private final Play play;
    private final int amount;

    public EnrichPerformance(String playId, int audience, Play play, int amount) {
        this.playId = playId;
        this.audience = audience;
        this.play = play;
        this.amount = amount;
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
}
