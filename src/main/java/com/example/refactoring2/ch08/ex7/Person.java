package com.example.refactoring2.ch08.ex7;

public class Person {
  private final int age;
  private final int salary;

  public Person(int age, int salary) {
    this.age = age;
    this.salary = salary;
  }

  public int getAge() {
    return age;
  }

  public int getSalary() {
    return salary;
  }
}
