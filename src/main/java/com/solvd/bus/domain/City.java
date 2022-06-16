package com.solvd.bus.domain;

import java.util.List;

public class City {

    private int id;

    private String name;

    private BusStop terminal;

    private List<BusStop> busStops;

    public City() {}

    public City(String name, BusStop terminal, List<BusStop> busStops) {
        this.id = id;
        this.name = name;
        this.terminal = terminal;
        this.busStops = busStops;
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
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", terminal=" + terminal +
                ", busStops=" + busStops +
                '}';
    }
}
