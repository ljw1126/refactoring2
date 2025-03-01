package com.example.refactoring2.ch07.ex1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class CustomerDataTest {
    private CustomerData customerData;

    @BeforeEach
    void setUp() {
        Map<String, MonthlyUsage> yearlyUsage = new HashMap<>();
        yearlyUsage.put("2016", new MonthlyUsage(new HashMap<>(Map.of("1", 50, "2", 55))));
        yearlyUsage.put("2015", new MonthlyUsage(new HashMap<>(Map.of("1", 70, "2", 63))));

        Map<String, Customer> customers = new HashMap<>();
        customers.put("1920", new Customer("1920", "마틴 파울러", yearlyUsage));

        customerData = new CustomerData(customers);
    }

    @Test
    void usage() {
        int actual = customerData.usage("1920", "2016", "1");

        assertThat(actual).isEqualTo(50);
    }

    @Test
    void setUsage() {
        String customerId = "1920";
        String year = "2015";
        String month = "1";
        int amount = 99;

        customerData.setUsage(customerId, year, month, amount);
        int actual = customerData.usage(customerId, year, month);

        assertThat(actual).isEqualTo(99);
    }

    @Test
    void compareUsage() {
        Result actual = customerData.compareUsage("1920", "2016", "1");

        assertThat(actual).isEqualTo(new Result(50, -20));
    }
}
