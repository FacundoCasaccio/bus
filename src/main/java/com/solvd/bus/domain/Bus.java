package com.solvd.bus.domain;

public class Bus {

    private String name;

    private Route route;

    public Bus() {}

    public Bus(String name, Route route) {
        this.name = name;
        this.route = route;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "name='" + name + '\'' +
                ", route=" + route +
                '}';
    }
}
