package com.example.refactoring2.ch10.ex5;

public class UnknownCustomer extends Customer {

  public UnknownCustomer() {
    super();
  }

  @Override
  public String getName() {
    return "거주자";
  }

  @Override
  public BillingPlan getBillingPlan() {
    return null; // registry.billingPlans.basic
  }

  @Override
  public void setBillingPlan(String arg) {
    // ignore
  }

  @Override
  public PaymentHistory getPaymentHistory() {
    return new NullPaymentHistory();
  }

  @Override
  public boolean isUnknown() {
    return true;
  }
}
