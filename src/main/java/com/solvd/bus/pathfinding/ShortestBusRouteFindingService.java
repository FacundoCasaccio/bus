package com.solvd.bus.pathfinding;

import com.solvd.bus.domain.Bus;
import com.solvd.bus.domain.BusStop;
import com.solvd.bus.domain.Route;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

public class ShortestBusRouteFindingService {
    public static final Logger LOGGER = LogManager.getLogger(ShortestBusRouteFindingService.class);

    private Set<BusStop> nodes = new HashSet<>(); // Most be equal to the collection of all bus stops
    private Set<Bus> buses = new HashSet<>(); // all buses

    private Set<Route> routes = new HashSet<>(); // all routes

    private LinkedHashMap<BusStop, Bus> path = new LinkedHashMap<>();
    private BusStop terminal1Coordinates;
    private BusStop terminal2Coordinates;
    BusStop nextBusStop = null;

    private Double distanceBetweenTwoNodes(BusStop node1, BusStop node2) {
        return Math.pow(Math.pow(node1.getLatitude(), 2) + Math.pow(node2.getLongitude(), 2), 0.5);
    }

    public Route getRouteByBusStopID(int busStop1ID) { //Service layer
        return null;
    }

    public Bus getBusByID(long busID) {

        return null;
    }

    public Bus getBusThatConnectTwoStops(BusStop stop1, BusStop stop2) {
        Bus busThatConnectBusStops = null;
        Set<Route> route1 = routes.stream().filter(route -> route.getBusStopID() == stop1.getBusStopID()).collect(Collectors.toSet()); //gives info about all de buses that have a stop in this busStopS
        Set<Route> route2 = routes.stream().filter(route -> route.getBusStopID() == stop2.getBusStopID()).collect(Collectors.toSet());

        for (Route destination : route2) {
            Long busThatConnectBusStopsID = route1.stream().filter(origin -> origin.getBusID() == destination.getBusStopID()).findFirst().get().getBusID();
            busThatConnectBusStops = getBusByID(busThatConnectBusStopsID);
        }
        return busThatConnectBusStops;
    }

    public BusStop getNextClosestBusStop(BusStop busStop1, BusStop busStop2) {
        Set<Route> route1 = routes.stream().filter(route -> route.getBusStopID() == busStop1.getBusStopID()).collect(Collectors.toSet()); //gives info abot all de buses that have a stop in this busStopS
        Map<BusStop, Double> distances = new HashMap<BusStop, Double>();
        for (BusStop node : nodes) {
            if (node.getBusStopID() > busStop1.getBusStopID()) {
                Double distance = distanceBetweenTwoNodes(busStop1, node) + distanceBetweenTwoNodes(node, busStop2);
                distances.put(node, distance);
            }
        }
        Double minDistance = distances.values().iterator().next();
        nextBusStop = distances.keySet().stream().filter(busStop -> minDistance.equals(distances.get(busStop))).findFirst().get();
        return nextBusStop;
    }

    public void getShortestPath(BusStop partialDestination) {
        BusStop lastBusStop = null;
        for (BusStop node : nodes) {
            while (path.entrySet().iterator().hasNext()) {
                lastBusStop = path.entrySet().iterator().next().getKey();
            }
            path.put(getNextClosestBusStop(lastBusStop, partialDestination), getBusThatConnectTwoStops(getNextClosestBusStop(lastBusStop, partialDestination), partialDestination));
            if (lastBusStop == partialDestination) {
                break;
            }
        }
    }

    public void buildShortestPathBtwTwoBusStops(BusStop originStop, BusStop destinationStop) {
        path.put(originStop, null);
        getShortestPath(terminal1Coordinates);
        getShortestPath(terminal2Coordinates);
        LOGGER.info("The shortest path is:");
        path.entrySet().stream().forEach(path -> LOGGER.info("Take bus " + path.getValue().getBusID() + "in the busStop " + path.getKey().getBusStopID()));
    }
}
