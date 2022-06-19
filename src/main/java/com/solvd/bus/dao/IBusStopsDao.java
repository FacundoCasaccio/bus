package com.solvd.bus.dao;

import com.solvd.bus.domain.Bus;
import com.solvd.bus.domain.BusStop;
import com.solvd.bus.domain.Road;

import java.util.List;

public interface IBusStopsDao extends IDao<BusStop> {

    @Override
    BusStop select(int id);

    @Override
    List<BusStop> selectAll();

    List<Bus> selectRoutes(int id);

    List<Road> selectRoadConnections(int id);
}
