package com.example.refactoring2.ch07.ex7;

public class Person {
    private final String name;
    private Department department;

    public Person(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public static class Department {
        private String chargeCode;
        private String manager;

        public Department(String chargeCode, String manager) {
            this.chargeCode = chargeCode;
            this.manager = manager;
        }

        public String getChargeCode() {
            return chargeCode;
        }

        public void setChargeCode(String chargeCode) {
            this.chargeCode = chargeCode;
        }

        public String getManager() {
            return manager;
        }

        public void setManager(String manager) {
            this.manager = manager;
        }
    }
}
