package com.example.refactoring2.ch12.ex8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Department extends Party {
  private final List<Integer> staff;

  public Department(String name, List<Integer> staff) {
    super(name);
    this.staff = new ArrayList<>(staff);
  }

  @Override
  public long monthlyCost() {
    return this.staff.stream().reduce(0, (sum, cost) -> sum + cost);
  }

  public int headCount() {
    return this.staff.size();
  }

  public List<Integer> getStaff() {
    return Collections.unmodifiableList(staff);
  }
}
