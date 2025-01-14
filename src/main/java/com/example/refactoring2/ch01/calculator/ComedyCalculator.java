package com.example.refactoring2.ch01.calculator;

import com.example.refactoring2.ch01.Performance;
import com.example.refactoring2.ch01.Play;

public class ComedyCalculator extends PerformanceCalculator{
    public ComedyCalculator(Performance performance, Play play) {
        super(performance, play);
    }

    @Override
    public int amount() {
        int result = 30_000;
        if(performance.getAudience() > 30) {
            result += 10_000 + 500 * (performance.getAudience() - 20);
        }
        result += 300 * performance.getAudience();

        return result;
    }

    @Override
    public int volumeCredits() {
        return super.volumeCredits() + (performance.getAudience() / 5);
    }
}
