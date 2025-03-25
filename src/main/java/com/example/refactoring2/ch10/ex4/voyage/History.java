package com.example.refactoring2.ch10.ex4.voyage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class History {
  private final List<ZoneProfit> zoneProfits;

  public History(List<ZoneProfit> zoneProfits) {
    this.zoneProfits = new ArrayList<>(zoneProfits);
  }

  public List<ZoneProfit> getZoneProfits() {
    return Collections.unmodifiableList(zoneProfits);
  }

  public int length() {
    return zoneProfits.size();
  }
}
