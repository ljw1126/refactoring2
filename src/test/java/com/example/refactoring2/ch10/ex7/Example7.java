package com.example.refactoring2.ch10.ex7;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class Example7 {

  @ParameterizedTest
  @MethodSource("peopleArguments")
  void existMiscreantTest(String[] people, boolean expected) {
    boolean actual = existMiscreant(people);

    assertThat(actual).isEqualTo(expected);
  }

  private static boolean existMiscreant(String[] people) {
    boolean found = false;

    for (String p : people) {
      if (!found) {
        if (p.equals("조커")) {
          // do something
          found = true;
        }

        if (p.equals("사루만")) {
          // do something
          found = true;
        }
      }
    }

    return found;
  }

  private static Stream<Arguments> peopleArguments() {
    return Stream.of(
        Arguments.of(new String[] {"홍길동", "이순신", "조커"}, true),
        Arguments.of(new String[] {"사루만", "프로도", "김리"}, true),
        Arguments.of(new String[] {"이상해씨", "파이리", "꼬부기"}, false));
  }
}
