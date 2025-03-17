package com.example.refactoring2.ch09.ex5;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OrderTest {

  @Test
  void createWithSameCustomerId() {
    RepositoryData repositoryData = new RepositoryData(); // 중앙 관리 객체

    Order order1 = new Order(1, 2, repositoryData);
    Order order2 = new Order(1, 2, repositoryData); // 같은 고객 ID 사용

    assertThat(order1.getCustomer()).isEqualTo(order2.getCustomer());
  }
}
