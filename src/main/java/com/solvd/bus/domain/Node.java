package com.solvd.bus.domain;

public class Node {
    private BusStop busStop;
    private Bus bus;

    public Node() {
    }

    public Node(BusStop busStop, Bus bus) {
        this.busStop = busStop;
        this.bus = bus;
    }

    public BusStop getBusStop() {
        return busStop;
    }

    public void setBusStop(BusStop busStop) {
        this.busStop = busStop;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    @Override
    public String toString() {
        return "Node{" +
                "busStop=" + busStop +
                ", bus=" + bus +
                '}';
    }
}
