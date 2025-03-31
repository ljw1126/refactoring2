package com.example.refactoring2.ch11.ex9;

public class Insurance {

  public int score(Candidate candidate, MedicalExam medicalExam, ScoringGuide scoringGuide) {
    int result = 0;
    int healthLevel = 0;
    boolean highMedicalRiskFlag = false;

    if (medicalExam.isSmoker()) {
      healthLevel += 10;
      highMedicalRiskFlag = true;
    }

    String certificationGrade = "regular";
    if (scoringGuide.startWithLowCertification(candidate.originState())) {
      certificationGrade = "low";
      result -= 5;
    }

    // do something ..

    result -= Math.max(healthLevel - 5, 0);
    return result;
  }
}
