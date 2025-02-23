package com.example.refactoring2.ch06.ex5;

public class Customer {
    private final Address address;

    public Customer(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public static class Address {
        private NewEngland state;

        public Address(NewEngland state) {
            this.state = state;
        }

        public NewEngland getState() {
            return state;
        }
    }
}
