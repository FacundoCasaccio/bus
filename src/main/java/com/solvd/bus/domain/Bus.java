package com.solvd.bus.domain;

public class Bus {

    private long busID;

    private String name;

    public Bus() {
    }

    public Bus(long id, String name) {
        this.busID = id;
        this.name = name;
    }

    public long getBusID() {
        return busID;
    }

    public void setBusID(long busID) {
        this.busID = busID;
    }

    public String getName() {
        return name;

    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "id=" + busID +
                ", name='" + name + '\'' +
                '}';
    }
}
