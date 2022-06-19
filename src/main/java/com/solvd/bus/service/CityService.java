package com.solvd.bus.service;

import com.solvd.bus.dao.IBusStopsDao;
import com.solvd.bus.dao.ICityDao;
import com.solvd.bus.domain.BusStop;
import com.solvd.bus.domain.City;
import com.solvd.bus.utils.AbstractFactory;
import com.solvd.bus.utils.MyBatisFactory;

import java.util.List;

public class CityService {

    private MyBatisFactory factory = (MyBatisFactory) AbstractFactory.getFactory("mybatis");

    private ICityDao cityMapper = (ICityDao) factory.getMapper("city");

    private IBusStopsDao busStopMapper = (IBusStopsDao) factory.getMapper("stop");

    public City getCityById(int id) {
        City city = cityMapper.select(id);

        //Populate bus stops
        List<BusStop> stops = cityMapper.selectBusStops(id);
        stops.forEach(stop -> {
            stop.setRoads(busStopMapper.selectRoadConnections(stop.getId()));
            stop.setRoutes(busStopMapper.selectRoutes(stop.getId()));
        });
        city.setBusStops(stops);

        //Populate terminal
        BusStop terminal = cityMapper.selectTerminal(id);
        terminal.setRoads(busStopMapper.selectRoadConnections(id));
        terminal.setRoutes(busStopMapper.selectRoutes(id));
        city.setTerminal(terminal);

        return city;
    }

    public List<City> getAllCities() {
        List<City> cities = cityMapper.selectAll();

        //Populate cities
        cities.forEach( city -> {
           final BusStop terminal = cityMapper.selectTerminal(city.getId());
           terminal.setRoads(busStopMapper.selectRoadConnections(city.getId()));
           terminal.setRoutes(busStopMapper.selectRoutes(city.getId()));

           final List<BusStop> stops = cityMapper.selectBusStops(city.getId());
           stops.forEach(stop -> {
                stop.setRoads(busStopMapper.selectRoadConnections(stop.getId()));
                stop.setRoutes(busStopMapper.selectRoutes(stop.getId()));
            });

           city.setTerminal(terminal);
           city.setBusStops(stops);
        });

        return cities;
    }
}
