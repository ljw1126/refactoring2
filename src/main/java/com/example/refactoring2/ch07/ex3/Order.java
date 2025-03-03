package com.example.refactoring2.ch07.ex3;

public class Order {
    private Priority priority;

    public Order(String aString) {
        this(Priority.from(aString));
    }

    public Order(Priority priority) {
        this.priority = priority;
    }

    public boolean isHigher() {
        return priority.isHigher();
    }

    public String getPriorityString() {
        return priority.getValue();
    }

    public void setPriority(String aString) {
        this.priority = Priority.from(aString);
    }
}
