package com.example.refactoring2.ch08.ex8;

import java.util.Arrays;
import java.util.List;

public class IndiaSearch {
  private IndiaSearch() {}

  public static List<SearchResult> acquireData(String input) {
    return Arrays.stream(input.split("\n"))
        .skip(1)
        .filter(line -> !line.trim().isEmpty())
        .map(line -> line.split(","))
        .filter(record -> record[1].trim().equals("India"))
        .map(record -> new SearchResult(record[0].trim(), record[2].trim()))
        .toList();
  }
}
