package com.example.refactoring2.ch10.ex4.voyage;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class RatingUtilsTest {

  @Test
  void ratingBTest() {
    Voyage voyage = new Voyage("서인도", 10);
    List<ZoneProfit> zoneProfits =
        List.of(
            new ZoneProfit("동인도", 5),
            new ZoneProfit("서인도", 15),
            new ZoneProfit("중국", -2),
            new ZoneProfit("서아프리카", 7));
    History history = new History(zoneProfits);
    String actual = RatingUtils.rating(voyage, history);

    assertThat(actual).isEqualTo("B");
  }

  @Test
  void ratingATest() {
    Voyage voyage = new Voyage("중국", 10);
    List<ZoneProfit> zoneProfits =
        List.of(
            new ZoneProfit("중국", 5),
            new ZoneProfit("동인도", 10),
            new ZoneProfit("서인도", 15),
            new ZoneProfit("서아프리카", 7),
            new ZoneProfit("동인도", 10),
            new ZoneProfit("중국", 20),
            new ZoneProfit("중국", 30),
            new ZoneProfit("중국", 10),
            new ZoneProfit("중국", 5),
            new ZoneProfit("중국", 25));
    History history = new History(zoneProfits); // 방문 기록 10개 이상
    String actual = RatingUtils.rating(voyage, history);

    assertThat(actual).isEqualTo("A");
  }
}
