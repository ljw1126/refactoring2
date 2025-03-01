package com.example.refactoring2.ch07.ex3;

public class Order {
    private Priority priority;

    public Order(Priority priority) {
        this.priority = priority;
    }

    public String getPriorityString() {
        return priority.getValue();
    }

    public void setPriority(String aString) {
        this.priority = new Priority(aString);
    }
}
