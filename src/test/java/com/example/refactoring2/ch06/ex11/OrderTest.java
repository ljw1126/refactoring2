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
        PriceData priceData = new PriceData(basePrice, quantity, discount);
        return applyShipping(priceData, shipping);
    }

    private static int applyShipping(PriceData priceData, Shipping shipping) {
        int shippingPerCase = (priceData.getBasePrice() > shipping.discountThreshold())
                ? shipping.discountedFee() : shipping.feePerCase();
        int shippingCost = priceData.getQuantity() * shippingPerCase;
        return priceData.getBasePrice() - priceData.getDiscount() + shippingCost;
    }

    static class PriceData {
        private final int basePrice;
        private final int quantity;
        private final int discount;

        public PriceData(int basePrice, int quantity, int discount) {
            this.basePrice = basePrice;
            this.quantity = quantity;
            this.discount = discount;
        }

        public int getBasePrice() {
            return basePrice;
        }

        public int getQuantity() {
            return quantity;
        }

        public int getDiscount() {
            return discount;
        }
    }
}
