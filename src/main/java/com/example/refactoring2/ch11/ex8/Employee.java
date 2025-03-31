package com.example.refactoring2.ch11.ex8;

import java.util.Arrays;

public record Employee(String name, String typeCode) {

  public static Employee createEngineer(String name) {
    return new Employee(name, "E");
  }

  public LegalTypeCode type() {
    return LegalTypeCode.from(typeCode);
  }

  enum LegalTypeCode {
    ENGINEER("E"),
    MANAGER("M"),
    SALESPERSON("S");

    private final String typeCode;

    LegalTypeCode(String typeCode) {
      this.typeCode = typeCode;
    }

    public static LegalTypeCode from(String typeCode) {
      return Arrays.stream(values())
          .filter(c -> c.typeCode.equals(typeCode))
          .findFirst()
          .orElseThrow(IllegalArgumentException::new);
    }
  }
}
