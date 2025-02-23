package com.example.refactoring2.ch06.ex5;

import java.util.Arrays;

public enum NewEngland {
    MA, CT, ME, VT, NH, RI;

    public static boolean inNewEngland(Customer customer) {
        return Arrays.stream(values())
                .anyMatch(state -> state == customer.getAddress().getState());
    }
}
