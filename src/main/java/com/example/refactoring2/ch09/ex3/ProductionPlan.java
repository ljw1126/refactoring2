package com.example.refactoring2.ch09.ex3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductionPlan {
  private int production;
  private List<Adjustment> adjustments;

  public ProductionPlan() {
    this.production = 0;
    this.adjustments = new ArrayList<>();
  }

  public int getProduction() {
    return production;
  }

  public void applyAdjustment(Adjustment adjustment) {
    this.adjustments.add(adjustment);
    this.production += adjustment.amount();
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    ProductionPlan that = (ProductionPlan) o;
    return production == that.production && Objects.equals(adjustments, that.adjustments);
  }

  @Override
  public int hashCode() {
    return Objects.hash(production, adjustments);
  }
}
