package com.solvd.bus.domain;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "trip")
public class Trip {

    private List<PathNode> pathNodes = new ArrayList<>();

    public Trip() {
    }

    public Trip(List<PathNode> pathNodes) {
        this.pathNodes = pathNodes;
    }

    @XmlElementWrapper(name = "tripSteps")
    @XmlElement(name = "pathNode")
    public List<PathNode> getPathNodes() {
        return pathNodes;
    }

    public void setPathNodes(List<PathNode> pathNodes) {
        this.pathNodes = pathNodes;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "pathNodes=" + pathNodes +
                '}';
    }
}
