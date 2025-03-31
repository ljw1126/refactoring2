package com.example.refactoring2.ch11.ex12;

import java.util.HashMap;
import java.util.Map;

public class CountryData {
  private final Map<String, String> countryShippinRule;

  public CountryData() {
    this(new HashMap<>());
  }

  public CountryData(Map<String, String> countryShippinRule) {
    this.countryShippinRule = countryShippinRule;
  }

  public String shippingRules(String country) {
    return this.countryShippinRule.get(country);
  }
}
