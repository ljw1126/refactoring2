package com.example.refactoring2.ch11.ex1;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MiscreantVillainTest {

  @Spy private AlarmService alarmService;

  @InjectMocks private MiscreantVillain miscreantVillain;

  @DisplayName("빌런이 있으면 alarmService를 호출하고 이름을 반환한다")
  @ParameterizedTest
  @CsvSource({"조커", "사루만"})
  void alertForMiscreantTest(String name) {
    String[] people = new String[] {"unknown", name};

    String actual = miscreantVillain.alertForMiscreant(people);

    assertThat(actual).isEqualTo(name);
    verify(alarmService, times(1)).setOfAlarms();
  }

  @DisplayName("빌런이 없으면 빈 문자열을 반환한다")
  @Test
  void alertForMiscreantTest2() {
    String[] people = new String[] {"할리 퀸", "레이디 가가"};

    String actual = miscreantVillain.alertForMiscreant(people);

    assertThat(actual).isEmpty();
    verify(alarmService, times(0)).setOfAlarms();
  }
}
