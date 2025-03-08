package com.example.refactoring2.ch08.ex1;

public class TrackSummary {
  private final double totalDistance;
  private final double totalTime;
  private final double pace;

  public TrackSummary(double totalDistance, double totalTime, double pace) {
    this.totalDistance = totalDistance;
    this.totalTime = totalTime;
    this.pace = pace;
  }

  public double getTotalDistance() {
    return totalDistance;
  }

  public double getTotalTime() {
    return totalTime;
  }

  public double getPace() {
    return pace;
  }
}
