package com.example.refactoring2.ch10.ex4.bird;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class BirdClassifierTest {

  @Test
  void plumagesTest() {
    List<Bird> birds =
        List.of(
            Bird.createBird(create("이름1", "유럽 제비")),
            Bird.createBird(create("이름2", "아프리카 제비")),
            Bird.createBird(create("이름3", "노르웨이 파랑 앵무")),
            Bird.createBird(create("이름4", "unknown")));

    Map<String, String> actual = BirdClassifier.plumages(birds);

    assertThat(actual)
        .containsEntry("이름1", "보통이다")
        .containsEntry("이름2", "보통이다")
        .containsEntry("이름3", "예쁘다")
        .containsEntry("이름4", "알 수 없다");
  }

  @Test
  void speedsTest() {
    List<Bird> birds =
        List.of(
            Bird.createBird(create("이름1", "유럽 제비")),
            Bird.createBird(create("이름2", "아프리카 제비")),
            Bird.createBird(create("이름3", "노르웨이 파랑 앵무")),
            Bird.createBird(create("이름4", "unknown")));

    Map<String, Integer> actual = BirdClassifier.speeds(birds);

    assertThat(actual)
        .containsEntry("이름1", 35)
        .containsEntry("이름2", 40)
        .containsEntry("이름3", 10)
        .containsEntry("이름4", 0);
  }

  private static Bird create(String name, String type) {
    return new Bird(name, type, 0, 0, false);
  }
}
