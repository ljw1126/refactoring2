package com.example.refactoring2.ch11.ex9;

public class Score {
  private final Candidate candidate;
  private final MedicalExam medicalExam;
  private final ScoringGuide scoringGuide;
  private int result;
  private int healthLevel;
  private boolean highMedicalRiskFlag;
  private String certificationGrade;

  public Score(Candidate candidate, MedicalExam medicalExam, ScoringGuide scoringGuide) {
    this.candidate = candidate;
    this.medicalExam = medicalExam;
    this.scoringGuide = scoringGuide;
  }

  public int execute() {
    {
      this.result = 0;
      this.healthLevel = 0;
      this.highMedicalRiskFlag = false;

      this.scoreSmoking();
      this.scoreLowCertification();

      // do something ..
      this.result -= Math.max(this.healthLevel - 5, 0);
      return this.result;
    }
  }

  private void scoreSmoking() {
    if (this.medicalExam.isSmoker()) {
      this.healthLevel += 10;
      this.highMedicalRiskFlag = true;
    }
  }

  private void scoreLowCertification() {
    this.certificationGrade = "regular";
    if (this.scoringGuide.startWithLowCertification(this.candidate.originState())) {
      this.certificationGrade = "low";
      this.result -= 5;
    }
  }
}
