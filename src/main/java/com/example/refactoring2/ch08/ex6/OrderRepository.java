package com.example.refactoring2.ch08.ex6;

public interface OrderRepository {
  Order findById(Long orderId);
}
