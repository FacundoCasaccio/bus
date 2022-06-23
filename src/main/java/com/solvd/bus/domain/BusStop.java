package com.solvd.bus.domain;

import java.util.List;

public class BusStop {
    private int id;

    private String name;

    private double latitude;

    private double longitude;

    private boolean terminal;

    private int cityID;

    private List<Bus> routes;

    private List<Road> roads;

    public BusStop() {
    }

    public int getId() {
        return id;
    }

    public void setId(int busStop) {
        this.id = busStop;
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

    public boolean isTerminal() {
        return terminal;
    }

    public void setTerminal(boolean terminal) {
        this.terminal = terminal;
    }

    public List<Road> getRoads() {
        return roads;
    }

    public void setRoads(List<Road> roads) {
        this.roads = roads;
    }

    public List<Bus> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Bus> routes) {
        this.routes = routes;
    }

    public int getCityID() {
        return cityID;
    }

    public void setCity(int cityID) {
        this.cityID = cityID;
    }

    @Override
    public String toString() {
        return "Go to bus stop " + name;
    }
}
