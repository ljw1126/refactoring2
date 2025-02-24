package com.example.refactoring2.ch06.ex11;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("6.11 단계 쪼개기")
class OrderTest {

    @DisplayName("단순 주문 가격 계산")
    @Test
    void simplePriceOrderTest() {
        Product product = new Product(100, 10, 5);
        Shipping shipping = new Shipping(500, 1000, 10);

        int result = priceOrder(product, 5, shipping); // 기본료 500 + 배송비 50

        assertThat(result).isEqualTo(550);
    }

    private int priceOrder(Product product, int quantity, Shipping shipping) {
        int basePrice = product.basePrice() * quantity;
        int discount = Math.max(quantity - product.discountThreshold(), 0)
                * product.basePrice() * product.discountRate();
        int shippingPerCase = (basePrice > shipping.discountThreshold())
                ? shipping.discountedFee() : shipping.feePerCase();
        int shippingCost = quantity * shippingPerCase;
        int price = basePrice - discount + shippingCost;
        return price;
    }
}
