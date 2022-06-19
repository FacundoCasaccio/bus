package com.solvd.bus.domain;

import java.util.List;

public class Bus {

    private int id;

    private String name;

    public Bus() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Bus: " + name + ", id: " + id + "\n";
    }
}
