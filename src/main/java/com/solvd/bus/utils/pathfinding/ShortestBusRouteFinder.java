package com.solvd.bus.utils.pathfinding;

import com.solvd.bus.domain.Bus;
import com.solvd.bus.domain.BusStop;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class ShortestBusRouteFinder {
    public static final Logger LOGGER = LogManager.getLogger(ShortestBusRouteFinder.class);
    private Set<BusStop> nodes = new HashSet<>();
    private BusStop terminal1Coordinates;
    private BusStop terminal2Coordinates;

    private final Map<BusStop, Bus> path = new LinkedHashMap<>();

    public Set<BusStop> getNodes() {
        return nodes;
    }

    public void setNodes(Set<BusStop> nodes) {
        this.nodes = nodes;
    }

    public BusStop getTerminal1Coordinates() {
        return terminal1Coordinates;
    }

    public void setTerminal1Coordinates(BusStop terminal1Coordinates) {
        this.terminal1Coordinates = terminal1Coordinates;
    }

    public BusStop getTerminal2Coordinates() {
        return terminal2Coordinates;
    }

    public void setTerminal2Coordinates(BusStop terminal2Coordinates) {
        this.terminal2Coordinates = terminal2Coordinates;
    }

    public Map<BusStop, Bus> getPath() {
        return path;
    }

    public Double distanceBetweenTwoNodes(BusStop node1, BusStop node2) {
        return Math.pow(Math.pow(node1.getLatitude() - node2.getLatitude(), 2) + Math.pow(node1.getLongitude() - node2.getLongitude(), 2), 0.5);
    }

    public BusStop getLastBusStop() {
        BusStop lastBusStop = null;
        int count = 0;

        for (int i = 0; i < path.size(); i++) {
            lastBusStop = path.keySet().iterator().next();
        }
        return lastBusStop;
    }

    public void getShortestPathBtwTwoBusStops(BusStop originStop, BusStop destinationStop) {
        path.put(originStop, null);
        int x = 0;
        while (x == 0) {
            findClosestNextNode(getLastBusStop(), destinationStop);
            if (getLastBusStop().equals(destinationStop)) {
                x = 1;
            }
        }
    }

    public void findClosestNextNode(BusStop node1, BusStop node2) {
        Bus busConnectingNodes;
        BusStop closestBusStop;
        Double minDistance = null;
        Double minDist = null;
        Map<Double, BusStop> closestNodes = new HashMap<>();
        Map<BusStop, Bus> busAndStop = new HashMap<>();
        for (Bus bus : node1.getRoutes()) {
            Map<Double, BusStop> distances = new HashMap<>();
            bus.getBusStops().forEach(busStop -> distances.put(distanceBetweenTwoNodes(node1, busStop) + distanceBetweenTwoNodes(busStop, node2), busStop));
            Iterator it = distances.keySet().stream().sorted().iterator();
            while (it.hasNext()) {
                minDistance = (Double) it.next();
            }
            BusStop partialClosestStop = distances.get(minDistance);
            closestNodes.put(minDistance, partialClosestStop);
            busAndStop.put(partialClosestStop, bus);
        }
        Iterator minDistIterator = closestNodes.keySet().stream().sorted().iterator();
        while (minDistIterator.hasNext()) {
            minDist = (Double) minDistIterator.next();
        }
        closestBusStop = closestNodes.get(minDist);
        busConnectingNodes = busAndStop.get(closestNodes.get(minDist));
        path.put(closestBusStop, busConnectingNodes);
    }

    public void buildShortestPathBtwTwoBusStops(BusStop stop1, BusStop stop2) {
        getShortestPathBtwTwoBusStops(stop1, terminal1Coordinates);
        getShortestPathBtwTwoBusStops(terminal1Coordinates, terminal2Coordinates);
        getShortestPathBtwTwoBusStops(terminal2Coordinates, stop2);
        LOGGER.info(path);
    }
}
