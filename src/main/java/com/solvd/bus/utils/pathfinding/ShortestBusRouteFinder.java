package com.solvd.bus.utils.pathfinding;

import com.solvd.bus.domain.Bus;
import com.solvd.bus.domain.BusStop;
import com.solvd.bus.domain.PathNode;
import com.solvd.bus.domain.Trip;
import com.solvd.bus.service.BusService;
import com.solvd.bus.service.BusStopService;
import com.solvd.bus.service.CityService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

public class ShortestBusRouteFinder {
    private static final Logger LOGGER = LogManager.getLogger(ShortestBusRouteFinder.class);
    private BusStop terminal1Coordinates;
    private BusStop terminal2Coordinates;
    private BusStopService busStopService;
    private BusService busService;
    private CityService cityService;
    private final Map<BusStop, Bus> path = new LinkedHashMap<>();

    public void setBusStopService(BusStopService busStopService) {
        this.busStopService = busStopService;
    }

    public void setBusService(BusService busService) {
        this.busService = busService;
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

    public void setCityService(CityService cityService) {
        this.cityService = cityService;
    }

    private double distanceBetweenTwoNodes(BusStop node1, BusStop node2) {
        return Math.pow(Math.pow(node1.getLatitude() - node2.getLatitude(), 2) + Math.pow(node1.getLongitude() - node2.getLongitude(), 2), 0.5);
    }

    private BusStop getLastBusStop() {
        List<Map.Entry<BusStop, Bus>> entryList = new ArrayList<>(path.entrySet());
        Map.Entry<BusStop, Bus> lastEntry = entryList.get(entryList.size() - 1);
        return lastEntry.getKey();
    }

    private void getShortestPathBtwTwoBusStops(BusStop destinationStop) {
        List<BusStop> busStopsVisited = new ArrayList<>();
        BusStop visitBusStop;
        while (true) {
            visitBusStop = getLastBusStop();
            if (busStopsVisited.contains(visitBusStop)) {
                break;
            } else {
                busStopsVisited.add(visitBusStop);
                findClosestNextNode(visitBusStop, destinationStop);
            }
        }
        path.put(destinationStop, getBusThatConnectTwoStops(getLastBusStop(), destinationStop));
    }

    private void findClosestNextNode(BusStop node1, BusStop node2) {
        node1 = busStopService.getStopById(node1.getId());
        node2 = busStopService.getStopById(node2.getId());
        Double partialMinDistance;
        Double totalMinDist;
        Map<Double, BusStop> closestNodes = new HashMap<>();
        Map<BusStop, Bus> busAndStop = new HashMap<>();
        for (Bus bus : node1.getRoutes()) {
            bus = busService.getBusById(bus.getId());
            Map<Double, BusStop> distances = new HashMap<>();
            for (BusStop busStop : bus.getBusStops()) {
                busStop = busStopService.getStopById(busStop.getId());
                double distance = distanceBetweenTwoNodes(node2, busStop) + distanceBetweenTwoNodes(busStop, node2);
                if (distance > 0) {
                    distances.put(distance, busStop);
                }
            }
            partialMinDistance = distances.keySet().stream().sorted().collect(Collectors.toList()).get(0);
            busAndStop.put(distances.get(partialMinDistance), bus);
            closestNodes.put(partialMinDistance, distances.get(partialMinDistance));
        }
        totalMinDist = closestNodes.keySet().stream().sorted().collect(Collectors.toList()).get(0);
        path.put(closestNodes.get(totalMinDist), busAndStop.get(closestNodes.get(totalMinDist)));
    }

    private Bus getBusThatConnectTwoStops(BusStop stop1, BusStop stop2) {
        Bus busThatConnectBusStops = null;
        for (Bus bus : stop1.getRoutes()) {
            bus = busService.getBusById(bus.getId());
            for (BusStop busStop : bus.getBusStops()) {
                busStop = busStopService.getStopById(busStop.getId());
                if (busStop.getId() == stop2.getId()) {
                    busThatConnectBusStops = bus;
                    break;
                }
            }
        }
        return busThatConnectBusStops;
    }

    public Trip buildShortestPathBtwTwoBusStops(BusStop stop1, BusStop stop2) {
        Trip trip = new Trip();
        path.put(stop1, null);
        getShortestPathBtwTwoBusStops(terminal1Coordinates);
        path.put(terminal2Coordinates, getBusThatConnectTwoStops(terminal1Coordinates, terminal2Coordinates));
        getShortestPathBtwTwoBusStops(stop2);
        path.entrySet().forEach(node -> {
            if (node.getValue() == null) {
                LOGGER.info("Take bus #connection and direct to stop Valencia Bus Terminal in Valencia City");
                trip.getPathNodes().add(new PathNode("Valencia Bus Terminal", "connection"));
            } else {
                trip.getPathNodes().add(new PathNode(node.getKey().getName(), node.getValue().getName()));
                LOGGER.info("Take bus #" + node.getValue().getName() + " and direct to stop " + node.getKey().getName() + " in " + cityService.getCityById(node.getKey().getCityID()).getName() + " City");
            }
        });
        LOGGER.info("You achieved your final destination!");
        return trip;
    }
}