package com.example.refactoring2.ch11.ex12;

public class OrderProcessingException extends RuntimeException {
  private final int code;

  public OrderProcessingException(int errorCode) {
    super("주문 처리 오류: " + errorCode);
    this.code = errorCode;
  }

  public int code() {
    return code;
  }

  public String name() {
    return "OrderProcessingError";
  }
}
