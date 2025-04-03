package com.example.refactoring2.ch11.ex12;

import java.util.ArrayList;
import java.util.List;

public class CountryRule {
  private final CountryData countryData;

  public CountryRule(CountryData countryData) {
    this.countryData = countryData;
  }

  public void topMethod(Order orderData) {
    List<ErrorInfo> errorList = new ArrayList<>();
    try {
      calculateShippingCosts(orderData);
    } catch (OrderProcessingException e) {
      errorList.add(new ErrorInfo(orderData, e.code()));
    } catch (Exception e) {
      throw new IllegalStateException(e);
    }
  }

  public void calculateShippingCosts(Order anOrder) {
    // 관련 없는 코드
    ShippingRules shippingRules = localShippingRules(anOrder.country());
    // 더 관련 없는 코드
  }

  public ShippingRules localShippingRules(String country) {
    String data = countryData.shippingRules(country);

    if (data == null) throw new OrderProcessingException(-23);

    return new ShippingRules(data);
  }
}
