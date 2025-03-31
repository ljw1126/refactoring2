package com.example.refactoring2.ch11.ex11;

public class GpsCalculator {
  private int totalAscent = 0;
  private int totalTime = 0;
  private int totalDistance = 1; // / by zero 때문에 1로 초기화
  private final Point[] points;

  public GpsCalculator(Point[] points) {
    this.points = points;
  }

  public double calculate() {
    calculateAscent();
    calculateTime();
    calculateDistance();
    return (double) totalTime / 60 / totalDistance;
  }

  public void calculateAscent() {
    for (int i = 1; i < points.length; i++) {
      int verticalChange = points[i].elevation() - points[i - 1].elevation();
      totalAscent += Math.max(verticalChange, 0);
    }
  }

  public void calculateTime() {
    // ignore: do something
  }

  public void calculateDistance() {
    // ignore: do something
  }
}
