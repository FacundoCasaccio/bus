package com.solvd.bus.domain;

import java.util.List;

public class City {

    private int id;

    private String name;

    private BusStop terminal;

    private List<BusStop> busStops;

    public City() {}

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

    public BusStop getTerminal() {
        return terminal;
    }

    public void setTerminal(BusStop terminal) {
        this.terminal = terminal;
    }

    public List<BusStop> getBusStops() {
        return busStops;
    }

    public void setBusStops(List<BusStop> busStops) {
        this.busStops = busStops;
    }

    @Override
    public String toString() {
        return "City: " + name + ", id: " + id + "\n" +
                "Name: " + name + "\n" +
                "Terminal: " + terminal + "\n" +
                "Stops: " + busStops + "\n";
    }
}
