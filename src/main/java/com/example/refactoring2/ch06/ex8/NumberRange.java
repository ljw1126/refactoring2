package com.example.refactoring2.ch06.ex8;

public class NumberRange {
    private final int min;
    private final int max;

    public NumberRange(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}
