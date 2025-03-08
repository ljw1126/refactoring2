package com.example.refactoring2.ch08.ex1;

public class AccountType {
    private final boolean premium;

    public AccountType(boolean premium) {
        this.premium = premium;
    }

    public boolean isPremium() {
        return premium;
    }
}
