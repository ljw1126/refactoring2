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
