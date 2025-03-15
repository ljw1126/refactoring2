package com.example.refactoring2.ch09.ex5;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Chat-GPT로 단위 테스트 생성 후 수정
class RepositoryDataTest {
  private RepositoryData repository;

  @BeforeEach
  void setUp() {
    repository = new RepositoryData();
  }

  @Test
  void registerCustomer_ShouldCreateNewCustomer_WhenNotExist() {
    Customer customer = repository.registerCustomer(1);

    assertThat(customer).isNotNull().isEqualTo(new Customer(1));
  }

  @Test
  void registerCustomer_ShouldReturnExistingCustomer_WhenAlreadyRegistered() {
    Customer customer1 = repository.registerCustomer(1);
    Customer customer2 = repository.registerCustomer(1);

    assertThat(customer1).isEqualTo(customer2);
  }

  @Test
  void findCustomer_ShouldReturnCustomer_WhenExists() {
    repository.registerCustomer(1);
    Customer customer = repository.findCustomer(1);

    assertThat(customer).isNotNull().isEqualTo(new Customer(1));
  }

  @Test
  void findCustomer_ShouldReturnNull_WhenCustomerNotExists() {
    Customer customer = repository.findCustomer(999); // 존재하지 않는 ID

    assertThat(customer).isNull();
  }
}
