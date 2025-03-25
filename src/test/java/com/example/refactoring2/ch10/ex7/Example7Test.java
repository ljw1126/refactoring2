package com.example.refactoring2.ch10.ex7;

import static org.assertj.core.api.Assertions.*;

import java.util.Set;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Example7Test {

  @ParameterizedTest
  @MethodSource("peopleArguments")
  void existMiscreantTest(String[] people, boolean expected) {
    boolean actual = existMiscreant(people);

    assertThat(actual).isEqualTo(expected);
  }

  private static boolean existMiscreant(String[] people) {
    Set<String> miscreant = Set.of("조커", "사루만");
    return Stream.of(people).anyMatch(miscreant::contains);
  }

  private static Stream<Arguments> peopleArguments() {
    return Stream.of(
        Arguments.of(new String[] {"홍길동", "이순신", "조커"}, true),
        Arguments.of(new String[] {"사루만", "프로도", "김리"}, true),
        Arguments.of(new String[] {"이상해씨", "파이리", "꼬부기"}, false));
  }
}
