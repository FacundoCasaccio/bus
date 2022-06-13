package com.solvd.bus.domain;

import java.util.List;

public class Route {

    private BusStop startPoint;

    private BusStop endPoint;

    private List<Path> steps;

    private double distance;

    public Route() {}

    public Route(BusStop startPoint, BusStop endPoint, List<Path> steps, double distance) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.steps = steps;
        this.distance = distance;
    }

    public BusStop getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(BusStop startPoint) {
        this.startPoint = startPoint;
    }

    public BusStop getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(BusStop endPoint) {
        this.endPoint = endPoint;
    }

    public List<Path> getSteps() {
        return steps;
    }

    public void setSteps(List<Path> steps) {
        this.steps = steps;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Route{" +
                "startPoint=" + startPoint +
                ", endPoint=" + endPoint +
                ", steps=" + steps +
                ", distance=" + distance +
                '}';
    }
}
