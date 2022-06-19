package com.solvd.bus.domain;

public class Bus {

    private long id;

    private String name;

    public Bus() {
    }

    public Bus(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
