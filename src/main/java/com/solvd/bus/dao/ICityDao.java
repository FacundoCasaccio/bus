package com.solvd.bus.dao;

import com.solvd.bus.domain.Bus;
import com.solvd.bus.domain.BusStop;
import com.solvd.bus.domain.City;

import java.util.List;

public interface ICityDao extends IDao<City> {

    @Override
    City select(int id);

    @Override
    List<City> selectAll();

    List<BusStop> selectBusStops(int id);

    BusStop selectTerminal(int id);
}
