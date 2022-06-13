package com.solvd.bus.domain;

public class Path {

    private String name;

    private String startPoint;

    private String endPoint;

    public Path() {}

    public Path(String name, String startPoint, String endPoint) {
        this.name = startPoint + "-" + endPoint;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    @Override
    public String toString() {
        return "Path{" +
                "name='" + name + '\'' +
                ", startPoint='" + startPoint + '\'' +
                ", endPoint='" + endPoint + '\'' +
                '}';
    }
}
