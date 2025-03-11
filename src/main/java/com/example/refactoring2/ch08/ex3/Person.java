package com.example.refactoring2.ch08.ex3;

public class Person {
  private final String name;
  private final Photo photo;

  public Person(String name, Photo photo) {
    this.name = name;
    this.photo = photo;
  }

  public String name() {
    return name;
  }

  public Photo photo() {
    return photo;
  }
}
