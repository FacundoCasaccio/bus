package com.solvd.bus;

import com.solvd.bus.domain.City;
import com.solvd.bus.domain.Trip;
import com.solvd.bus.service.BusService;
import com.solvd.bus.service.BusStopService;
import com.solvd.bus.service.CityService;
import com.solvd.bus.utils.JaxbParser;
import com.solvd.bus.utils.parser.WriterJSON;
import com.solvd.bus.utils.pathfinding.ReadNumericOptionsFromUser;
import com.solvd.bus.utils.pathfinding.ShortestBusRouteFinder;
import jakarta.xml.bind.JAXBException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    private static final Logger LOGGER = LogManager.getLogger(Runner.class);


    public static void main(String[] args) {
        ReadNumericOptionsFromUser read = new ReadNumericOptionsFromUser();
        BusService busService = new BusService();
        BusStopService busStopService = new BusStopService();
        CityService cityService = new CityService();
        ShortestBusRouteFinder shortestBusRouteFinder = new ShortestBusRouteFinder();
        City barcelonaCity = cityService.getCityById(1);
        City valenciaCity = cityService.getCityById(2);
        shortestBusRouteFinder.setBusService(busService);
        shortestBusRouteFinder.setBusStopService(busStopService);
        shortestBusRouteFinder.setCityService(cityService);
        shortestBusRouteFinder.setTerminal1Coordinates(busStopService.getStopById(1));
        shortestBusRouteFinder.setTerminal2Coordinates(busStopService.getStopById(14));
        LOGGER.info("================================================================================================================================");
        LOGGER.info("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + "WELCOME!");
        LOGGER.info("--------------------------------------------------------------------------------------------------------------------------------");
        LOGGER.info("\t\t\tWe are going to help you find the shortest route from a bus stop in Barcelona to another in Valencia");
        LOGGER.info("\t\t\t\t\t\t\t\t\t\tThe stops available in each city are displayed:");
        LOGGER.info("--------------------------------------------------------------------------------------------------------------------------------");
        LOGGER.info("\t\t\t\t\tBus Stops at Barcelona City" + "\t\t\t\t\t|\t\t\t\t\t\t" + "Bus Stops at Valencia City");
        int minSize = Math.min(cityService.getCityById(1).getBusStops().size(), cityService.getCityById(2).getBusStops().size());
        int maxSize = Math.max(cityService.getCityById(1).getBusStops().size(), cityService.getCityById(2).getBusStops().size());
        List<Integer> barcelonaBusStopsIDs = new ArrayList<>();
        List<Integer> valenciaBusStopsIDs = new ArrayList<>();
        for (int i = 0; i < minSize; i++) {
            barcelonaBusStopsIDs.add(barcelonaCity.getBusStops().get(i).getId());
            valenciaBusStopsIDs.add(valenciaCity.getBusStops().get(i).getId());
            LOGGER.info("\t\t\t\t\t" + barcelonaCity.getBusStops().get(i).getId() + ". " + barcelonaCity.getBusStops().get(i).getName() + " -> " + "\t\t\t\t\t\t\t\t\t" + "|\t\t\t\t\t\t" + valenciaCity.getBusStops().get(i).getId() + ". "
                    + valenciaCity.getBusStops().get(i).getName());
        }
        LOGGER.info("================================================================================================================================");
        LOGGER.info("Please choose your origin bus stop from the Barcelona City bus Stop's list:");
        int originStopID = read.optionFromUser(barcelonaBusStopsIDs);
        LOGGER.info("Please choose your origin bus stop from the Valencia City bus Stop's list:");
        int destinationStopID = read.optionFromUser(valenciaBusStopsIDs);
        LOGGER.info("================================================================================================================================");
        LOGGER.info("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + "The shortest route created is:");

        Trip finalTrip = shortestBusRouteFinder.buildShortestPathBtwTwoBusStops(busStopService.getStopById(originStopID), busStopService.getStopById(destinationStopID));

        WriterJSON writerJSON = new WriterJSON(finalTrip);
        writerJSON.writeJSON();

        try {
            JaxbParser.marshallTrip(finalTrip);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

        LOGGER.info("The path created was stores in XML format in the file named 'trip.xml' and in JSON format in the file 'trip.json'");
    }
}