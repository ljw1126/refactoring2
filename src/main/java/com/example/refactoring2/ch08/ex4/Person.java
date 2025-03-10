package com.example.refactoring2.ch08.ex4;

import java.util.List;

public class Person {
  private final String name;
  private final Photo photo;
  private final List<Photo> photos;

  public Person(String name, Photo photo, List<Photo> photos) {
    this.name = name;
    this.photo = photo;
    this.photos = photos;
  }

  public String name() {
    return name;
  }

  public Photo photo() {
    return photo;
  }

  public List<Photo> photos() {
    return photos;
  }
}
