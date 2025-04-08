package com.example.refactoring2.ch12.ex10.part2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BirdTest {

  @Test
  void birdTest() {
    BirdDto birdDto = new BirdDto("unknown", "조류", "깃털", 0, 0, false);
    Bird bird = Bird.from(birdDto);

    assertThat(bird.plumage()).isEqualTo("깃털");
    assertThat(bird.airSpeedVelocity()).isNull();
  }

  @Test
  void europeanSwallowTest() {
    BirdDto birdDto = new BirdDto("유럽 제비", "유럽 제비", "", 10, 0, false);
    Bird bird = Bird.from(birdDto);

    assertThat(bird.plumage()).isEqualTo("보통이다");
    assertThat(bird.airSpeedVelocity()).isEqualTo(35);
  }

  @Test
  void africanSwallowTest() {
    BirdDto birdDto = new BirdDto("아프리카 제비", "아프리카 제비", "", 10, 0, false);
    Bird bird = Bird.from(birdDto);

    assertThat(bird.plumage()).isEqualTo("보통이다");
    assertThat(bird.airSpeedVelocity()).isEqualTo(20);
  }

  @Test
  void norwegianBlueParrotTest() {
    BirdDto birdDto = new BirdDto("노르웨이 파랑 앵무", "노르웨이 파랑 앵무", "", 10, 101, true);
    Bird bird = Bird.from(birdDto);

    assertThat(bird.plumage()).isEqualTo("그을렸다");
    assertThat(bird.airSpeedVelocity()).isZero();
  }
}
