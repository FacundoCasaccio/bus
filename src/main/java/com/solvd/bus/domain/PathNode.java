package com.solvd.bus.domain;

public class PathNode {
    private String busStopName;
    private BusStop busID;

    public PathNode() {
    }

    public PathNode(String busStopName, BusStop busID) {
        this.busStopName = busStopName;
        this.busID = busID;
    }

    public String getBusStopName() {
        return busStopName;
    }

    public void setBusStopName(String busStopName) {
        this.busStopName = busStopName;
    }

    public BusStop getBusID() {
        return busID;
    }

    public void setBusID(BusStop busID) {
        this.busID = busID;
    }
}
