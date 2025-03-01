package com.example.refactoring2.ch07.ex2;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private final String name;
    private List<Course> courses;

    public Person(String name, List<Course> courses) {
        this.name = name;
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public int numAdvancedCourses() {
        return (int) this.courses.stream()
                .filter(Course::isAdvanced)
                .count();
    }
}
