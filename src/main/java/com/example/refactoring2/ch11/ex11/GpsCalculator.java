package com.example.refactoring2.ch11.ex11;

public class GpsCalculator {
  private final Point[] points;

  public GpsCalculator(Point[] points) {
    this.points = points;
  }

  public double calculate() {
    int totalAscent = calculateAscent();
    int totalTime = calculateTime();
    int totalDistance = calculateDistance();
    return (double) totalTime / 60 / totalDistance;
  }

  public int calculateAscent() {
    int result = 0;
    for (int i = 1; i < points.length; i++) {
      int verticalChange = points[i].elevation() - points[i - 1].elevation();
      result += Math.max(verticalChange, 0);
    }

    return result;
  }

  public int calculateTime() {
    // ignore: do something
    return 0;
  }

  public int calculateDistance() {
    // ignore: do something
    // / by zero 때문에 1로 초기화
    return 1;
  }
}
