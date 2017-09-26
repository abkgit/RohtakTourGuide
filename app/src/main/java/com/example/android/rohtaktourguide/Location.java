package com.example.android.rohtaktourguide;

public class Location {

    private int mName;

    private int mAddress;

    private int mDescription;

    private double mLatitude;

    private double mLongitude;

    private int mImageResourceId;


    public Location(int name, int address, int description,
                    double latitude, double longitude, int imageResourceId) {
        this.mName = name;
        this.mAddress = address;
        this.mDescription = description;
        this.mLatitude = latitude;
        this.mLongitude = longitude;
        this.mImageResourceId = imageResourceId;
    }

    public int getName() {
        return mName;
    }

    public int getAddress() {
        return mAddress;
    }

    public int getDescription() {
        return mDescription;
    }

    public double getLatitude() {
        return mLatitude;
    }

    public double getLongitude() {
        return mLongitude;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }
}




