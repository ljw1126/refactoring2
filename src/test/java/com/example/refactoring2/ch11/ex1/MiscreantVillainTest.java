package com.example.refactoring2.ch11.ex1;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MiscreantVillainTest {

  @DisplayName("빌런이 있으면 알림을 off로 변경하고, 이름을 반환한다")
  @ParameterizedTest
  @CsvSource({"조커", "사루만"})
  void alertForMiscreantTestWhenExistVillain(String name) {
    String[] people = new String[] {"unknown", name};

    Alarm alarm = new Alarm();
    MiscreantVillain miscreantVillain = new MiscreantVillain(alarm);

    String actual = miscreantVillain.findMiscreant(people);
    miscreantVillain.alertForMiscreant(people);

    assertThat(actual).isEqualTo(name);
    assertThat(alarm.isOn()).isFalse();
  }

  @DisplayName("빌런이 없으면 알림은 on을 유지하고, 빈 문자열을 반환한다")
  @Test
  void alertForMiscreantTestWhenWithoutVillain() {
    String[] people = new String[] {"할리 퀸", "레이디 가가"};

    Alarm alarm = new Alarm();
    MiscreantVillain miscreantVillain = new MiscreantVillain(alarm);

    String actual = miscreantVillain.findMiscreant(people);
    miscreantVillain.alertForMiscreant(people);

    assertThat(actual).isEmpty();
    assertThat(alarm.isOn()).isTrue();
  }
}
