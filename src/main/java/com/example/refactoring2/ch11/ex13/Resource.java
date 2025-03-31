package com.example.refactoring2.ch11.ex13;

public record Resource(String name) {
  public static Resource create() {
    return new Resource("dummy");
  }
}
