package com.solvd.bus.pathfinding;

import com.solvd.bus.domain.Bus;
import com.solvd.bus.domain.BusStop;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

public class ShortestBusRouteFindingService {
    public static final Logger LOGGER = LogManager.getLogger(ShortestBusRouteFindingService.class);

    private LinkedHashSet<BusStop> nodes; // MOst be equal to the collection of all bus stops
    private Set<Bus> buses = new HashSet<>();
    private BusStop terminal1Coordinates;
    private BusStop terminal2Cordinates;
    BusStop node1 = null;
    BusStop node2 = null;
    BusStop nextBusStop = null;

    private Double distancebetweenTwoNodes(BusStop node1, BusStop node2) {
        return Math.pow(Math.pow(node1.getLatitude(), 2) + Math.pow(node2.getLongitude(), 2), 0.5);
    }

    public BusStop getShortestPathBtwTwoNodes(int busStop1ID) {
        ArrayList<Double> distances = new ArrayList<>();
        for (BusStop node : nodes) {
            if (node.getId() == busStop1ID) {
                node1 = node;
                break;
            }
            nodes.stream().forEach(busStop -> {
                while (busStop.getId() > busStop1ID) {
                    Double distance = distancebetweenTwoNodes(node1, busStop) + distancebetweenTwoNodes(busStop, terminal1Coordinates);
                    distances.add(distance);
                    if (distance == distances.stream().sorted().toArray()[1]) {
                        nextBusStop = (BusStop) Arrays.asList(distances.toArray()).get(busStop.getId());
                        //to save the info in a queue of the bus ta connect the firt stop with the next bus stop.
                        break;
                    }
                }
            });
        }
        return nextBusStop;
    }

    public Set<Bus> getShortestPath(int stopID) {
        while (nextBusStop != terminal1Coordinates) {
            getShortestPathBtwTwoNodes(nextBusStop.getId());
        }
        return buses;
    }
}
