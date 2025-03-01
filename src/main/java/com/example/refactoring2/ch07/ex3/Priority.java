package com.example.refactoring2.ch07.ex3;

import java.util.Arrays;

public enum Priority {
    LOW("low", 1),
    NORMAL("normal", 2),
    HIGH("high", 3),
    RUSH("rush", 4);

    private final String value;
    private final int index;

    Priority(String value, int weight) {
        this.value = value;
        this.index = weight;
    }

    public String getValue() {
        return value;
    }

    public int getIndex() {
        return index;
    }

    public static Priority from(String value) {
        return Arrays.stream(values())
                .filter(p -> p.value.equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(value + "는 유효하지 않은 우선순위입니다"));
    }

    public boolean isHigher() {
        return this == HIGH || this == RUSH;
    }

    public boolean higherThan(Priority other) {
        return this.index > other.index;
    }

    public boolean lowerThan(Priority other) {
        return this.index < other.index;
    }
}
