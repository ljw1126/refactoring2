package com.example.refactoring2.ch01.calculator;

import com.example.refactoring2.ch01.Performance;
import com.example.refactoring2.ch01.Play;

public class TragedyCalculator extends PerformanceCalculator{

    public TragedyCalculator(Performance performance, Play play) {
        super(performance, play);
    }

    @Override
    public int amount() {
        int result = 40_000;

        if(performance.audience() > 30) {
            result += 1_000 * (performance.audience() - 30);
        }

        return result;
    }
}
