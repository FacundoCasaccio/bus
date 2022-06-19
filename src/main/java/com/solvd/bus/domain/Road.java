package com.solvd.bus.domain;

import java.util.List;

public class Road {
    private int id;

    private String name;

    private List<BusStop> endPoints;

    public Road() {
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

    public List<BusStop> getEndPoints() {
        return endPoints;
    }

    public void setEndPoints(List<BusStop> endPoints) {
        this.endPoints = endPoints;
    }

    @Override
    public String toString() {
        return "Road: " + name + ", id: " + id + "\n";
    }
}
