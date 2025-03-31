package com.example.refactoring2.ch11.ex9;

public class Insurance {

  public int score(Candidate candidate, MedicalExam medicalExam, ScoringGuide scoringGuide) {
    return new Score(candidate, medicalExam, scoringGuide).execute();
  }
}
