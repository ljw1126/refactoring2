package com.example.refactoring2.ch08.ex4;

import java.io.IOException;
import java.io.OutputStreamWriter;

public class HtmlTemplateV2 {
  private HtmlTemplateV2() {}

  public static String renderPerson(OutputStreamWriter outputStreamWriter, Person person)
      throws IOException {
    outputStreamWriter.write("<p>" + person.name() + "</p>\n");
    writeParagraph(outputStreamWriter, person.name());
    renderPhoto(outputStreamWriter, person.photo());
    emmitPhotoData(outputStreamWriter, person.photo());
    writeParagraph(outputStreamWriter, "위치: " + person.photo().location());
    return outputStreamWriter.toString();
  }

  private static void renderPhoto(OutputStreamWriter outputStreamWriter, Photo photo)
      throws IOException {
    outputStreamWriter.write(photo.title() + "\n");
  }

  private static void emmitPhotoData(OutputStreamWriter outputStreamWriter, Photo aPhoto)
      throws IOException {
    writeParagraph(outputStreamWriter, "제목: " + aPhoto.title());
    writeParagraph(outputStreamWriter, "날짜: " + aPhoto.date().toString());
  }

  private static void writeParagraph(OutputStreamWriter outputStreamWriter, String content)
      throws IOException {
    outputStreamWriter.write("<p>" + content + "</p>\n");
  }
}
