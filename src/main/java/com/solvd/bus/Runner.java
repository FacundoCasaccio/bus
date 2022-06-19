package com.solvd.bus;

import com.solvd.bus.service.BusService;
import com.solvd.bus.service.BusStopService;
import com.solvd.bus.service.CityService;
import com.solvd.bus.service.RoadService;
import com.solvd.bus.utils.SessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Runner {

    private static final Logger LOGGER = LogManager.getLogger(Runner.class);
    private static SessionFactory factory = SessionFactory.getInstance();

    public static void main(String[] args) {
        BusService busService = new BusService();
        BusStopService busStopService = new BusStopService();
        RoadService roadService = new RoadService();
        CityService cityService = new CityService();

        try (SqlSession session = factory.getFactory().openSession()) {
//            LOGGER.info(busService.getBusById(1));
//            LOGGER.info(busService.getAllBuses());
//
//            LOGGER.info(busStopService.getStopById(4));
//            LOGGER.info(busStopService.getAllStops());
//
//            LOGGER.info(roadService.getRoadById(1));
//            LOGGER.info(roadService.getAllRoads());
//
//            LOGGER.info(cityService.getCityById(1));
//            LOGGER.info(cityService.getAllCities());
        }
    }
}
