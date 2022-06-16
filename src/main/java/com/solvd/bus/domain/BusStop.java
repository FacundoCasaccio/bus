package com.solvd.bus.domain;

import java.util.List;

public class BusStop {

    private int id;

    private String name;

    private double latitude;

    private double longitude;

    private List<Bus> busCombinations;

    private List<Road> roads;

    public BusStop() {}

    public BusStop(int id, String name, double latitude, double longitude) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<Bus> getBusCombinations() {
        return busCombinations;
    }

    public void setBusCombinations(List<Bus> busCombinations) {
        this.busCombinations = busCombinations;
    }

    @Override
    public String toString() {
        return "BusStop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
