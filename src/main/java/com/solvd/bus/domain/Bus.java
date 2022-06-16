package com.solvd.bus.domain;

import java.util.List;

public class Bus {

    private int id;

    private String name;

    private List<BusStop> stops;

    public Bus() {}

    public Bus(int id, String name, List<BusStop> stops) {
        this.id = id;
        this.name = name;
        this.stops = stops;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BusStop> getStops() {
        return stops;
    }

    public void setStops(List<BusStop> stops) {
        this.stops = stops;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "name='" + name + '\'' +
                ", stops=" + stops +
                '}';
    }
}
