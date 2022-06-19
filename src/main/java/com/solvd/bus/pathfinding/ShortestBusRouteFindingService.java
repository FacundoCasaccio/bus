package com.solvd.bus.pathfinding;

import com.solvd.bus.domain.Bus;
import com.solvd.bus.domain.BusStop;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ShortestBusRouteFindingService {
    public static final Logger LOGGER = LogManager.getLogger(ShortestBusRouteFindingService.class);

    private Set<BusStop> nodes; // Most be equal to the collection of all bus stops
    private Set<Bus> buses = new HashSet<>();
    private BusStop terminal1Coordinates;
    private BusStop terminal2Coordinates;
    BusStop nextBusStop = null;

    private Double distanceBetweenTwoNodes(BusStop node1, BusStop node2) {
        return Math.pow(Math.pow(node1.getLatitude(), 2) + Math.pow(node2.getLongitude(), 2), 0.5);
    }

    public void get() {
        for (BusStop busStop : nodes) {

        }
    }

    public BusStop getShortestPathBtwTwoNodes(int busStop1ID) {
        BusStop node1 = null;
        ArrayList<Double> distances = new ArrayList<>();
        for (BusStop node : nodes) {
            if (node.getId() == busStop1ID) {
                node1 = node;
                break;
            }
            nodes.stream().forEach(busStop -> {
                while (busStop.getId() > busStop1ID) {
                    Double distance = distanceBetweenTwoNodes(node1, busStop) + distanceBetweenTwoNodes(busStop, terminal1Coordinates);
                    distances.add(distance);
                    if (distance == distances.stream().sorted().toArray()[1]) {
                        nextBusStop = (BusStop) Arrays.asList(distances.toArray()).get(busStop.getId());
                        //to save the info in a queue of the bus ta connect the first stop with the next bus stop.
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
