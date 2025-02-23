package com.example.refactoring2.ch06.ex5;

import java.util.Arrays;

public enum NewEngland {
    MA, CT, ME, VT, NH, RI;

    public static boolean inNewEngland(NewEngland state) {
        return Arrays.stream(values())
                .anyMatch(code -> code == state);
    }
}
