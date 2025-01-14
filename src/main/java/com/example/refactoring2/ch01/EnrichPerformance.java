package com.example.refactoring2.ch01;

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
        int amount = amountFor(performance, play);
        int volumeCredits = volumeCreditsFor(performance, play);

        return new EnrichPerformance(playId, audience, play, amount, volumeCredits);
    }

    private static int volumeCreditsFor(Performance performance, Play play) {
        int result = 0;
        result += Math.max(performance.getAudience() - 30, 0);

        if(play.getType().equals(PlayType.COMEDY)) {
            result += (performance.getAudience() / 5);
        }

        return result;
    }

    private static int amountFor(Performance performance, Play play) throws Exception {
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
