package com.solvd.bus.domain;

import java.util.ArrayList;
import java.util.List;

public class Bus {
    private int id;
    private String name;

    private List<BusStop> busStops = new ArrayList<>();

    public Bus() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<BusStop> getBusStops() {
        return busStops;
    }

    public void setBusStops(List<BusStop> busStops) {
        this.busStops = busStops;
    }

    @Override
    public String toString() {
        return "Bus: " + name + ", id: " + id + "\n";
    }
}
