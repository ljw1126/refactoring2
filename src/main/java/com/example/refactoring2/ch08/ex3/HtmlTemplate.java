package com.example.refactoring2.ch08.ex3;

import java.util.StringJoiner;

public class HtmlTemplate {
  private HtmlTemplate() {}

  public static String renderPerson(Person person) {
    StringJoiner result = new StringJoiner("\n");
    result.add("<p>" + person.name() + "</p>");
    result.add(renderPhoto(person.photo()));
    result.add(emitPhotoData(person.photo()));
    return result.toString();
  }

  private static String renderPhoto(Photo photo) {
    return photoDiv(photo);
  }

  private static String photoDiv(Photo aPhoto) {
    StringJoiner result = new StringJoiner("\n");
    result.add("<div>");
    result.add(emitPhotoData(aPhoto));
    result.add("</div>");
    return result.toString();
  }

  private static String emitPhotoData(Photo aPhoto) {
    StringJoiner result = new StringJoiner("\n");
    result.add("<p>제목: " + aPhoto.title() + "</p>"); // 여기
    result.add("<p>위치: " + aPhoto.location() + "</p>");
    result.add("<p>날짜: " + aPhoto.date().toString() + "</p>");
    return result.toString();
  }
}
