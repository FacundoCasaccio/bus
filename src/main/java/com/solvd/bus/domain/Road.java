package com.solvd.bus.domain;

import java.util.List;

public class Road {

    private int id;

    private String name;

    private List<BusStop> endPoints;

    public Road() {}

    public Road(int id, String name, List<BusStop> endPoints) {
        this.id = id;
        this.name = name;
        this.endPoints = endPoints;
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
        return "Road{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", endPoints=" + endPoints +
                '}';
    }
}
