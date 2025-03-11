package com.example.refactoring2.ch08.ex6;

public class BillingService {

  private final PricingPlanRepository pricingPlanRepository;
  private final OrderRepository orderRepository;

  public BillingService(
      PricingPlanRepository pricingPlanRepository, OrderRepository orderRepository) {
    this.pricingPlanRepository = pricingPlanRepository;
    this.orderRepository = orderRepository;
  }

  public double processOrder(Long orderId) {
    // 가격 정책과 주문 정보를 가져온다
    PricingPlan pricingPlan = pricingPlanRepository.findPricingPlan();
    Order order = orderRepository.findById(orderId);

    // 기본 청구 금액을 계산한다
    int baseCharge = pricingPlan.getBase();
    int chargePerUnit = pricingPlan.getUnitCharge();
    int units = order.getUnits();
    double charge = (double) baseCharge + (double) (units * chargePerUnit);

    // 할인 금액을 계산한다
    int discountableUnits = Math.max(units - pricingPlan.getDiscountThreshold(), 0);
    double discount = discountableUnits * pricingPlan.getDiscountFactor();
    if (order.isRepeatOrder()) {
      discount += 20;
    }

    return charge - discount;
  }
}
