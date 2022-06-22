package com.solvd.bus.domain;

public class PathNode {
    private String busStopName;
    private String busName;

    public PathNode() {
    }

    public PathNode(String busStopName, String busName) {
        this.busStopName = busStopName;
        this.busName = busName;
    }

    public String getBusStopName() {
        return busStopName;
    }

    public void setBusStopName(String busStopName) {
        this.busStopName = busStopName;
    }

    public String getBusID() {
        return busName;
    }

    public void setBusID(String busID) {
        this.busName = busID;
    }
}
