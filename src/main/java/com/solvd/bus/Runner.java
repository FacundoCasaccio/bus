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

<<<<<<< HEAD
    public static void main(String[] args) throws IOException {
=======

    public static void main(String[] args) {
>>>>>>> d5d45550f13258b21a68293eecf53e42315b7477
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

<<<<<<< HEAD
        writerJSON jsonWrite = new writerJSON(trip);
        writerXML xmlWriter = new writerXML(trip);
        xmlWriter.writeXML();
        jsonWrite.writeJSON();
        
=======
>>>>>>> d5d45550f13258b21a68293eecf53e42315b7477
    }
}