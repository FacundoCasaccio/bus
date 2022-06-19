package com.solvd.bus.domain;

import java.util.ArrayList;
import java.util.List;


public class Trip {
    private List<PathNode> pathNodes = new ArrayList<>();

    public Trip() {
    }

    public Trip(List<PathNode> pathNodes) {
        this.pathNodes = pathNodes;
    }

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
