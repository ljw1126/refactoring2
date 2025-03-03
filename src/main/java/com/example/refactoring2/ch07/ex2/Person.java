package com.example.refactoring2.ch07.ex2;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private final String name;
    private final List<Course> courses;

    public Person(String name, List<Course> courses) {
        this.name = name;
        this.courses = new ArrayList<>(courses);
    }

    public void addCourse(Course aCourse) {
        this.courses.add(aCourse);
    }

    public boolean removeCourse(Course aCourse) {
        return this.courses.remove(aCourse);
    }

    public int numAdvancedCourses() {
        return (int) this.courses.stream()
                .filter(Course::isAdvanced)
                .count();
    }

    public String getName() {
        return name;
    }
}
