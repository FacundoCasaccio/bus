package com.solvd.bus.domain;

import java.util.List;

public class Trip {

    private Route route;

    private List<Bus> buses;

    public Trip() {
    }

    public Trip(Route route, List<Bus> buses) {
        this.route = route;
        this.buses = buses;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public List<Bus> getBuses() {
        return buses;
    }

    public void setBuses(List<Bus> buses) {
        this.buses = buses;
    }
}
