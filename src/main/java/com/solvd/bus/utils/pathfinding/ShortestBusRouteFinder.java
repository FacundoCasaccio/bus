package com.solvd.bus.utils.pathfinding;

import com.solvd.bus.domain.Bus;
import com.solvd.bus.domain.BusStop;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class ShortestBusRouteFinder {
    public static final Logger LOGGER = LogManager.getLogger(ShortestBusRouteFinder.class);
    private Set<BusStop> nodes = new HashSet<>();
    private LinkedHashMap<BusStop, Bus> path = new LinkedHashMap<>();
    private BusStop terminal1Coordinates;
    private BusStop terminal2Coordinates;

    public Set<BusStop> getNodes() {
        return nodes;
    }

    public void setNodes(Set<BusStop> nodes) {
        this.nodes = nodes;
    }

    public LinkedHashMap<BusStop, Bus> getPath() {
        return path;
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

    public Double distanceBetweenTwoNodes(BusStop node1, BusStop node2) {
        return Math.pow(Math.pow(node1.getLatitude(), 2) + Math.pow(node2.getLongitude(), 2), 0.5);
    }

    public Bus getBusThatConnectTwoStops(BusStop stop1, BusStop stop2) {
        Bus busThatConnectBusStops = null;
        for (Bus busFromStop2 : stop2.getRoutes()) {
            busThatConnectBusStops = stop1.getRoutes().stream().filter(busFromStop1 -> busFromStop1.getId() == busFromStop2.getId()).findFirst().get();
        }
        return busThatConnectBusStops;
    }

    public BusStop getNextClosestBusStop(BusStop busStop1, BusStop busStop2) {
//        Set<Route> route1 = routes.stream().filter(route -> route.getBusStopID() == busStop1.getBusStopID()).collect(Collectors.toSet()); //gives info abot all de buses that have a stop in this busStopS
        BusStop nextBusStop = null;
        Map<BusStop, Double> distances = new HashMap<BusStop, Double>();
        for (BusStop node : nodes) {
            if (node.getId() > busStop1.getId()) {
                Double distance = distanceBetweenTwoNodes(busStop1, node) + distanceBetweenTwoNodes(node, busStop2);
                distances.put(node, distance);
            }
        }
        Double minDistance = distances.values().iterator().next();
        nextBusStop = distances.keySet().stream().filter(busStop -> minDistance.equals(distances.get(busStop))).findFirst().get();
        return nextBusStop;
    }

    private BusStop getLastPath(){
        BusStop lastBusStop = null;
        while (path.entrySet().iterator().hasNext()) {
            lastBusStop = path.entrySet().iterator().next().getKey();
        }
        return lastBusStop;
    }

    public void getShortestPath(BusStop partialDestination) {
        LOGGER.info("llegue");
        for (BusStop node : nodes) {
            BusStop lastBusStop = getLastPath();
            if (lastBusStop == partialDestination) {
                break;
            }
            path.put(getNextClosestBusStop(lastBusStop, partialDestination), getBusThatConnectTwoStops(getNextClosestBusStop(lastBusStop, partialDestination), partialDestination));
        }
    }

    public void buildShortestPathBtwTwoBusStops(BusStop originStop, BusStop destinationStop) {
        path.put(originStop, null);
        getShortestPath(terminal1Coordinates);
        getShortestPath(terminal2Coordinates);
        getShortestPath(destinationStop);
        LOGGER.info("The shortest path is:");
        path.entrySet().stream().forEach(path -> LOGGER.info("Take bus " + path.getValue().getId() + "in the busStop " + path.getKey().getId()));
    }
}
