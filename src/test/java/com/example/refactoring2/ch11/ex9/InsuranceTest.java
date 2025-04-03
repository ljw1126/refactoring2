package com.example.refactoring2.ch11.ex9;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InsuranceTest {
  @Test
  void scoreTest() {
    ScoringGuide scoringGuide = new ScoringGuide();
    MedicalExam medicalExam = new MedicalExam(false);
    Candidate candidate = new Candidate("high");

    Insurance insurance = new Insurance();
    int actual = insurance.score(candidate, medicalExam, scoringGuide);

    assertThat(actual).isZero();
  }

  @DisplayName("흡연자인 경우")
  @Test
  void scoreTest2() {
    ScoringGuide scoringGuide = new ScoringGuide();
    MedicalExam medicalExam = new MedicalExam(true);
    Candidate candidate = new Candidate("high");

    Insurance insurance = new Insurance();
    int actual = insurance.score(candidate, medicalExam, scoringGuide);

    assertThat(actual).isEqualTo(-5);
  }

  @DisplayName("흡연자이고, 상태가 low 인경우")
  @Test
  void scoreTest3() {
    ScoringGuide scoringGuide = new ScoringGuide();
    MedicalExam medicalExam = new MedicalExam(true);
    Candidate candidate = new Candidate("lowState");

    Insurance insurance = new Insurance();
    int actual = insurance.score(candidate, medicalExam, scoringGuide);

    assertThat(actual).isEqualTo(-10);
  }
}
