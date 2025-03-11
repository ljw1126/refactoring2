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
        .filter(arr -> arr[1].trim().equals("India"))
        .map(arr -> new SearchResult(arr[0].trim(), arr[2].trim()))
        .toList();
  }
}
