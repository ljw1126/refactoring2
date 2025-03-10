package com.example.refactoring2.ch08.ex4;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

public class HtmlTemplate {

  public static String renderPerson(OutputStreamWriter outputStreamWriter, Person person)
      throws IOException {
    outputStreamWriter.write("<p>" + person.name() + "</p>\n");
    renderPhoto(outputStreamWriter, person.photo());
    emitPhotoData(outputStreamWriter, person.photo());
    return outputStreamWriter.toString();
  }

  private static void renderPhoto(OutputStreamWriter outputStreamWriter, Photo photo)
      throws IOException {
    outputStreamWriter.write("doSomething\n");
  }

  private static void listRecentPhotos(OutputStreamWriter outputStreamWriter, List<Photo> photos)
      throws IOException {
    for (Photo photo : photos) {
      // 조건식
      outputStreamWriter.write("<div>\n");
      emitPhotoData(outputStreamWriter, photo);
      outputStreamWriter.write("</div>\n");
    }
  }

  private static void emitPhotoData(OutputStreamWriter outputStreamWriter, Photo aPhoto)
      throws IOException {
    outputStreamWriter.write("<p>제목: " + aPhoto.title() + "</p>\n");
    outputStreamWriter.write("<p>위치: " + aPhoto.location() + "</p>\n");
    outputStreamWriter.write("<p>날짜: " + aPhoto.date().toString() + "</p>\n");
  }
}
