package com.example.refactoring2.ch07.ex1;

import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

public class CustomerData {
    private Map<String, Customer> data;

    public CustomerData(Map<String, Customer> data) {
        this.data = new HashMap<>();

        for (Map.Entry<String, Customer> entry : data.entrySet()) {
            this.data.put(entry.getKey(), new Customer(entry.getValue()));
        }
    }

    public int usage(String customerId, String year, String month) {
        Map<String, Customer> copied = rawData();
        Customer customer = copied.get(customerId);
        return customer.usages(year, month);
    }

    /**
     * 주어진 고객의 최근 사용량과 이전 사용량의 차이를 계산합니다.
     *
     * @param customerId 고객 ID
     * @param laterYear 연도 (예: "2022")
     * @param month 비교할 월(예: "03")
     * @return 사용량 차이 결과를 담은 UsageResult 객체
     */
    public Result compareUsage(String customerId, String laterYear, String month) {
        Map<String, Customer> copied = rawData();

        Customer customer = copied.get(customerId);
        int later = customer.usages(laterYear, month);
        int earlier = customer.usages(String.valueOf(Integer.parseInt(laterYear) - 1), month);

        return new Result(later, later - earlier);
    }

    private Map<String, Customer> rawData() {
        return new CustomerData(this.data).data;
    }

    public void setUsage(String customerId, String year, String month, int amount) {
        Customer customer = this.data.get(customerId);

        Assert.notNull(customer, "Customer is Null");

        customer.setUsage(year, month, amount);
    }
}
