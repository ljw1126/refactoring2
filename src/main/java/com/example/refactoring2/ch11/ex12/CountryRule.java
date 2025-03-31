package com.example.refactoring2.ch11.ex12;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CountryRule {
  private final CountryData countryData;

  public CountryRule(CountryData countryData) {
    this.countryData = countryData;
  }

  public void topMethod(Order orderData) {
    Object status = calculateShippingCosts(orderData);
    List<ErrorInfo> errorList = new ArrayList<>();
    if (!(status instanceof ShippingRules) && (int) status < 0) {
      errorList.add(new ErrorInfo(orderData, (int) status));
    }
  }

  public Object calculateShippingCosts(Order anOrder) {
    // 관련 없는 코드

    Object shippingRules = localShippingRules(anOrder.country());
    if (!(shippingRules instanceof ShippingRules)) {
      return shippingRules; // 오류 전파
    }

    // 더 관련 없는 코드
    return BigDecimal.valueOf(0);
  }

  public Object localShippingRules(String country) {
    String data = countryData.shippingRules(country);

    if (data == null) return -23;

    return new ShippingRules(data);
  }
}
