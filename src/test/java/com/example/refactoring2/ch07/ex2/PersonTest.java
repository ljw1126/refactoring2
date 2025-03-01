package com.example.refactoring2.ch07.ex2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PersonTest {

    @DisplayName("주입한 컬렉션의 참조를 끊지 않는 경우, 외부에서 코스 추가시 원본도 영향을 받는다")
    @Test
    void addCourse1() {
        List<Course> courses = new ArrayList<>();
        courses.add(new Course("코스1"));
        courses.add(new Course("코스2"));
        Person person = new Person("name", courses);

        courses.add(new Course("추가 코드", false));

        assertThat(person.getCourses()).hasSize(3);
    }

    @DisplayName("게터로 코스 컬렉션을 가져와 수정할 경우, 원본 컬렉션도 수정된다")
    @Test
    void addCourse2() {
        List<Course> courses = new ArrayList<>();
        courses.add(new Course("코스1"));
        courses.add(new Course("코스2"));
        Person person = new Person("name", courses);

        person.getCourses().add(new Course("추가 코드", false));

        assertThat(person.getCourses()).hasSize(3);
    }
}
