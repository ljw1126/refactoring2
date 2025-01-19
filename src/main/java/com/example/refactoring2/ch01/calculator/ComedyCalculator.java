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
        if(performance.audience() > 30) {
            result += 10_000 + 500 * (performance.audience() - 20);
        }
        result += 300 * performance.audience();

        return result;
    }

    @Override
    public int volumeCredits() {
        return super.volumeCredits() + (performance.audience() / 5);
    }
}
