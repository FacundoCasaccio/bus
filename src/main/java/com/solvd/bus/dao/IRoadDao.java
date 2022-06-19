package com.solvd.bus.dao;

import com.solvd.bus.domain.BusStop;
import com.solvd.bus.domain.Road;

import java.util.List;

public interface IRoadDao extends IDao<Road> {

    @Override
    Road select(int id);

    @Override
    List<Road> selectAll();

    List<BusStop> selectEndpoints(int id);
}
