package com.example.refactoring2.ch12.ex8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Department {
  private final String name;
  private final List<Integer> staff;

  public Department(String name, List<Integer> staff) {
    this.name = name;
    this.staff = new ArrayList<>(staff);
  }

  public long totalMonthlyCost() {
    return this.staff.stream().reduce(0, (sum, cost) -> sum + cost);
  }

  public int headCount() {
    return this.staff.size();
  }

  public long totalAnnualCost() {
    return this.totalMonthlyCost() * 12;
  }

  public String getName() {
    return name;
  }

  public List<Integer> getStaff() {
    return Collections.unmodifiableList(staff);
  }
}
