package com.solvd.bus.domain;

public class BusStop {

    private int id;

    private double latitude;

    private double longitude;

    private String name;

    private long cityID;

    public BusStop() {
    }

    public BusStop(int id, double latitude, double longitude, String name, long city_id) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.cityID = city_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCityID() {
        return cityID;
    }

    public void setCityID(long cityID) {
        this.cityID = cityID;
    }

    @Override
    public String toString() {
        return "BusStop{" +
                "id=" + id +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", name='" + name + '\'' +
                ", cityID=" + cityID +
                '}';
    }
}
