package com.example.refactoring2.ch08.ex3;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

class HtmlTemplateTest {

  @Test
  void renderPersonTest() {
    LocalDateTime now = LocalDateTime.now();
    Person person = new Person("홍길동", new Photo("풍경", "서울", now));

    String actual = HtmlTemplate.renderPerson(new ByteArrayOutputStream(), person);

    String expected =
        String.join(
            "\n",
            "<p>홍길동</p>",
            "<div>",
            "<p>제목: 풍경</p>",
            "<p>위치: 서울</p>",
            "<p>날짜: " + now.toString() + "</p>",
            "</div>",
            "<p>제목: 풍경</p>",
            "<p>위치: 서울</p>",
            "<p>날짜: " + now.toString() + "</p>");

    assertThat(actual).isEqualTo(expected);
  }
}
