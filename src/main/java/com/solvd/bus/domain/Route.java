package com.solvd.bus.domain;

public class Route {

    private long id;

    private long busStopID;
    private long busID;


    public Route(long id, long busStopID, long busID) {
        this.id = id;
        this.busStopID = busStopID;
        this.busID = busID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBusStopID() {
        return busStopID;
    }

    public void setBusStopID(long busStopID) {
        this.busStopID = busStopID;
    }

    public long getBusID() {
        return busID;
    }

    public void setBusID(long busID) {
        this.busID = busID;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", busStopID=" + busStopID +
                ", busID=" + busID +
                '}';
    }
}
