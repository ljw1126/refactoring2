package com.example.refactoring2.ch10.ex5;

public class Customer {
  private String name;
  private BillingPlan billingPlan; // 요금제
  private PaymentHistory paymentHistory; // 납부 이력

  public Customer() {}

  public Customer(String name, BillingPlan billingPlan, PaymentHistory paymentHistory) {
    this.name = name;
    this.billingPlan = billingPlan;
    this.paymentHistory = paymentHistory;
  }

  public String getName() {
    return name;
  }

  public BillingPlan getBillingPlan() {
    return billingPlan;
  }

  public void setBillingPlan(String arg) {
    // do something
  }

  public PaymentHistory getPaymentHistory() {
    return paymentHistory;
  }

  public boolean isUnknown() {
    return false;
  }
}
