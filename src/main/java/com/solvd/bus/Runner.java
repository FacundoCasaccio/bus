package com.solvd.bus;

import com.solvd.bus.domain.BusStop;
import com.solvd.bus.domain.Trip;
import com.solvd.bus.service.BusStopService;
import com.solvd.bus.service.CityService;
import com.solvd.bus.utils.writerJSON;
import com.solvd.bus.utils.SessionFactory;
import com.solvd.bus.utils.writerXML;
import com.solvd.bus.utils.pathfinding.ShortestBusRouteFinder;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Runner {

    private static final Logger LOGGER = LogManager.getLogger(Runner.class);
    private static SessionFactory factory = SessionFactory.getInstance();

    public static void main(String[] args) throws IOException {
        BusStopService busStopService = new BusStopService();
        CityService cityService = new CityService();
        ShortestBusRouteFinder shortestBusRouteFinder = new ShortestBusRouteFinder();
        BusStop stop1;
        BusStop stop2;
        try (SqlSession session = factory.getFactory().openSession()) {
            shortestBusRouteFinder.getNodes().addAll(busStopService.getAllStops());
            shortestBusRouteFinder.setTerminal1Coordinates(cityService.getCityById(1).getTerminal());
            shortestBusRouteFinder.setTerminal2Coordinates(cityService.getCityById(2).getTerminal());
            stop1 = cityService.getCityById(1).getBusStops().stream().findFirst().get();
            stop2 = cityService.getCityById(2).getBusStops().stream().findFirst().get();
            LOGGER.info(stop1);
        }

        shortestBusRouteFinder.buildShortestPathBtwTwoBusStops(stop1, stop2);

        Trip trip = new Trip();

        writerJSON jsonWrite = new writerJSON(trip);
        writerXML xmlWriter = new writerXML(trip);
        xmlWriter.writeXML();
        jsonWrite.writeJSON();
        
    }
}
