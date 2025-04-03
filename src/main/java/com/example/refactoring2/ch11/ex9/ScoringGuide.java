package com.example.refactoring2.ch11.ex9;

public record ScoringGuide() {
  public boolean startWithLowCertification(String state) {
    return state.startsWith("low");
  }
}
