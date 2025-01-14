package com.example.refactoring2.ch01;

public class EnrichPerformance {
    private final String playId;
    private final int audience;
    private final Play play;

    public EnrichPerformance(String playId, int audience, Play play) {
        this.playId = playId;
        this.audience = audience;
        this.play = play;
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
}
