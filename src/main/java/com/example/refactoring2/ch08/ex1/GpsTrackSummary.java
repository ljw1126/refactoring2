package com.example.refactoring2.ch08.ex1;

import java.util.ArrayList;
import java.util.List;

public class GpsTrackSummary {
  private final List<Waypoint> points;

  public GpsTrackSummary(List<Waypoint> points) {
    this.points = new ArrayList<>(points);
  }

  public TrackSummary trackSummary() {
    double totalTime = calculateTime();
    double pace = totalTime / 60 / totalDistance();
    return new TrackSummary(totalTime, totalDistance(), pace);
  }

  private double totalDistance() {
    double result = 0;
    for (int i = 1; i < points.size(); i++) {
      Waypoint first = points.get(i - 1);
      Waypoint second = points.get(i);
      result += first.distance(second);
    }
    return result;
  }

  private double calculateTime() {
    if (points.isEmpty()) {
      return 0;
    }

    Waypoint last = points.get(points.size() - 1);
    Waypoint first = points.get(0);
    return last.diffTimestamp(first);
  }
}
