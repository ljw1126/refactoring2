package com.example.refactoring2.ch01.calculator;

import com.example.refactoring2.ch01.Performance;
import com.example.refactoring2.ch01.Play;

public abstract class PerformanceCalculator {
    protected final Performance performance;
    protected final Play play;

    protected PerformanceCalculator(Performance performance, Play play) {
        this.performance = performance;
        this.play = play;
    }

    public static PerformanceCalculator create(Performance performance, Play play) {
        return switch (play.type()) {
            case TRAGEDY -> new TragedyCalculator(performance, play);
            case COMEDY -> new ComedyCalculator(performance, play);
            default -> throw new IllegalArgumentException(String.format("알 수 없는 장르: %s", play.type()));
        };
    }

    public int volumeCredits() {
        return Math.max(performance.audience() - 30, 0);
    }

    public Play getPlay() {
        return play;
    }

    public abstract int amount();
}
