package com.example.refactoring2.ch06.ex1;

import java.time.LocalDate;
import java.util.List;

public class Invoice {
    private String customer;
    private LocalDate dueDate;
    private List<Order> orders;

    public Invoice(String customer, List<Order> orders) {
        this(customer, LocalDate.now(), orders);
    }

    public Invoice(String customer, LocalDate dueDate, List<Order> orders) {
        this.customer = customer;
        this.dueDate = dueDate;
        this.orders = orders;
    }

    public void printOwing() {
        int outstanding = 0;

        System.out.println("************");
        System.out.println("****고객 채무***");
        System.out.println("************");

        // 미해결 채무(outstanding)를 계산한다
        for(Order o : this.orders) {
            outstanding += o.amount;
        }

        // 마감일을 기록한다
        this.dueDate = this.dueDate.plusDays(30);

        // 세부사항을 출력한다
        System.out.println("고객명: " + this.customer);
        System.out.println("채무액: " + outstanding);
        System.out.println("마감일: " + dueDate.toString());
    }

    public static class Order {
        private final int amount;

        public Order(int amount) {
            this.amount = amount;
        }

        public int getAmount() {
            return amount;
        }
    }
}
