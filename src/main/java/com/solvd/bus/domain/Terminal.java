package com.solvd.bus.domain;

public class Terminal extends BusStop{

    private boolean terminal;

    public Terminal() {}

    public Terminal(String name, double latitude, double longitude) {
        super(name, latitude, longitude);
        this.terminal = true;
    }

    public boolean isTerminal() {
        return terminal;
    }

    public void setTerminal(boolean terminal) {
        this.terminal = terminal;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "terminal=" + terminal +
                '}';
    }
}
