package com.example.refactoring2.ch07.ex2;

public class Course {
    private final String name;
    private final boolean isAdvanced;

    public Course(String name) {
        this(name, false);
    }

    public Course(String name, boolean isAdvanced) {
        this.name = name;
        this.isAdvanced = isAdvanced;
    }

    public String getName() {
        return name;
    }

    public boolean isAdvanced() {
        return isAdvanced;
    }
}
