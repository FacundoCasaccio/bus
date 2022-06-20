package com.solvd.bus;

import com.solvd.bus.domain.BusStop;
import com.solvd.bus.service.BusStopService;
import com.solvd.bus.service.CityService;
import com.solvd.bus.utils.SessionFactory;
import com.solvd.bus.utils.pathfinding.ShortestBusRouteFinder;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Runner {

    private static final Logger LOGGER = LogManager.getLogger(Runner.class);
    private static SessionFactory factory = SessionFactory.getInstance();


    public static void main(String[] args) {
        BusStopService busStopService = new BusStopService();
        CityService cityService = new CityService();
        ShortestBusRouteFinder shortestBusRouteFinder = new ShortestBusRouteFinder();
        BusStop origin;
        BusStop destination;
        try (SqlSession session = factory.getFactory().openSession()) {
            shortestBusRouteFinder.setTerminal1Coordinates(cityService.getCityById(1).getTerminal());
            shortestBusRouteFinder.setTerminal2Coordinates(cityService.getCityById(2).getTerminal());
            origin = busStopService.getStopById(6);
            destination = busStopService.getStopById(11);
        }
        shortestBusRouteFinder.buildShortestPathBtwTwoBusStops(origin, destination);
    }
}