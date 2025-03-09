package com.example.refactoring2.ch08.ex8;

import java.util.ArrayList;
import java.util.List;

public class IndiaSearch {
  private IndiaSearch() {}

  public static List<SearchResult> acquireData(String input) {
    String[] lines = input.split("\n");
    boolean firstLine = true;
    List<SearchResult> result = new ArrayList<>();
    for (String line : lines) {
      if (firstLine) {
        firstLine = false;
        continue;
      }

      if (line.trim().equals("")) continue;

      String[] record = line.split(",");
      if (record[1].trim().equals("India")) {
        result.add(new SearchResult(record[0].trim(), record[2].trim()));
      }
    }

    return result;
  }
}
