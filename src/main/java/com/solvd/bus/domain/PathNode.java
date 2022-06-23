package com.solvd.bus.domain;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "pathNode")
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

    @XmlAttribute(name = "busStopName")
    public void setBusStopName(String busStopName) {
        this.busStopName = busStopName;
    }

    public String getBusID() {
        return busName;
    }

    @XmlAttribute(name = "busId")
    public void setBusID(String busID) {
        this.busName = busID;
    }
}
