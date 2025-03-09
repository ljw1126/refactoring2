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
    PricingPlan pricingPlan = pricingPlanRepository.findPricingPlan();
    Order order = orderRepository.findById(orderId);

    double charge = 0.0;
    int baseCharge = pricingPlan.getBase();
    int chargePerUnit = pricingPlan.getUnitCharge();
    int units = order.getUnits();
    double discount = 0;
    charge = baseCharge + units * chargePerUnit;
    int discountableUnits = Math.max(units - pricingPlan.getDiscountThreshold(), 0);
    discount = discountableUnits * pricingPlan.getDiscountFactor();
    if (order.isRepeatOrder()) discount += 20;
    charge = charge - discount;
    return charge;
  }
}
