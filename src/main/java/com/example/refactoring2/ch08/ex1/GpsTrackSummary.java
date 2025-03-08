package com.example.refactoring2.ch08.ex1;

import java.util.List;

public class GpsTrackSummary {
    private GpsTrackSummary() {}

    public static TrackSummary trackSummary(List<Waypoint> points) {
        double totalTime = calculateTime(points);
        double pace = totalTime / 60 / totalDistance(points);
        return new TrackSummary(totalTime, totalDistance(points), pace);
    }

    private static double totalDistance(List<Waypoint> points) {
        double result = 0;
        for(int i = 1; i < points.size(); i++) {
            result += distance(points.get(i - 1), points.get(i));
        }
        return result;
    }

    private static double distance(Waypoint p1, Waypoint p2) {
        int earthRadius = 6371;
        double dLat = radians(p2.getLatitude() - p1.getLatitude());
        double dLon = radians(p2.getLongitude() - p1.getLongitude());

        double a = Math.pow(Math.sin(dLat / 2), 2) + Math.cos(radians(p2.getLatitude()))
                * Math.cos(radians(p1.getLatitude())) * Math.pow(Math.sin(dLon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return earthRadius * c;
    }

    private static double radians(double degrees) {
        return degrees * Math.PI / 180;
    }

    private static double calculateTime(List<Waypoint> points) {
        if (points.isEmpty()) {
            return 0;
        }

        return points.get(points.size() - 1).getTimestamp() - points.get(0).getTimestamp();
    }
}

