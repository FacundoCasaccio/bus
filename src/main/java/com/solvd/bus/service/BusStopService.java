package com.solvd.bus.service;

import com.solvd.bus.dao.IBusStopsDao;
import com.solvd.bus.domain.BusStop;
import com.solvd.bus.utils.AbstractFactory;
import com.solvd.bus.utils.MyBatisFactory;

import java.util.List;

public class BusStopService {

    private MyBatisFactory factory = (MyBatisFactory) AbstractFactory.getFactory("mybatis");

    private IBusStopsDao busStopMapper = (IBusStopsDao) factory.getMapper("stop");

    public BusStop getStopById(int id) {
        BusStop stop = busStopMapper.select(id);
        stop.setRoutes(busStopMapper.selectRoutes(id));
        stop.setRoads(busStopMapper.selectRoadConnections(id));
        return stop;
    }

    public List<BusStop> getAllStops() {
        List<BusStop> stops = busStopMapper.selectAll();
        stops.forEach(stop -> {
            stop.setRoads(busStopMapper.selectRoadConnections(stop.getId()));
            stop.setRoutes(busStopMapper.selectRoutes(stop.getId()));
        });
        return stops;
    }
}
