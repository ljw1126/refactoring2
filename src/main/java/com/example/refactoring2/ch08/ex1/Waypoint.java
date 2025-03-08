package com.example.refactoring2.ch08.ex1;

public class Waypoint {
    private final double latitude;
    private final double longitude;
    private final double timestamp;

    public Waypoint(double latitude, double longitude, double timestamp) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.timestamp = timestamp;
    }

    public double distance(Waypoint other) {
        int earthRadius = 6371;
        double dLat = radians(other.latitude - this.latitude);
        double dLon = radians(other.longitude - this.longitude);

        double a = Math.pow(Math.sin(dLat / 2), 2) + Math.cos(radians(other.latitude))
                * Math.cos(radians(this.latitude)) * Math.pow(Math.sin(dLon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return earthRadius * c;
    }

    private double radians(double degrees) {
        return degrees * Math.PI / 180;
    }

    public double diffTimestamp(Waypoint other) {
        return this.timestamp - other.timestamp;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getTimestamp() {
        return timestamp;
    }
}
