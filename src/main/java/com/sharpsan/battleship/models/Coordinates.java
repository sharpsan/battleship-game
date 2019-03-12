package com.sharpsan.battleship.models;

public class Coordinates {

    private final int latitude, longitude;

    public Coordinates(int latitude, int longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // grid coordinate array values are offset
    // by 1 less than counting numbers
    private int toArrayIndex(int value) {
        return value - 1;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getArraySafeLatitude() {
        return toArrayIndex(latitude);
    }

    public int getArraySafeLongitude() {
        return toArrayIndex(longitude);
    }
}
