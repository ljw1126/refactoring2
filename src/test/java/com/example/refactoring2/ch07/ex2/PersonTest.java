package com.example.refactoring2.ch07.ex2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PersonTest {

    private List<Course> courses;

    @BeforeEach
    void setUp() {
        courses = new ArrayList<>();
        courses.add(new Course("코스1"));
        courses.add(new Course("코스2"));
    }

    @DisplayName("생성자에서 컬렉션을 얕은 복사하면 외부 참조를 끊을 수 있다")
    @Test
    void init() {
        Person person = new Person("name", courses);

        courses.add(new Course("코스3"));

        assertThat(person.numAdvancedCourses()).isEqualTo(0);
    }

    @DisplayName("메서드를 통해 컬렉션에 코스를 추가할 수 있다")
    @Test
    void addCourse() {
        Person person = new Person("name", courses);

        person.addCourse(new Course("코스3", true));

        assertThat(person.numAdvancedCourses()).isEqualTo(1);
    }

    @Test
    void removeCourse() {
        Person person = new Person("name", courses);
        Course course = new Course("코스3", true);
        person.addCourse(course);

        boolean actual = person.removeCourse(new Course("코스3", true));

        assertThat(actual).isTrue();
        assertThat(person.numAdvancedCourses()).isZero();
    }
}
