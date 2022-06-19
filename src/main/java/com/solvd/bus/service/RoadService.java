package com.solvd.bus.service;

import com.solvd.bus.dao.IRoadDao;
import com.solvd.bus.domain.BusStop;
import com.solvd.bus.domain.Road;
import com.solvd.bus.utils.AbstractFactory;
import com.solvd.bus.utils.MyBatisFactory;

import java.util.List;

public class RoadService {

    private MyBatisFactory factory = (MyBatisFactory) AbstractFactory.getFactory("mybatis");

    private IRoadDao roadMapper = (IRoadDao) factory.getMapper("road");

    public Road getRoadById(int id) {
        Road road = roadMapper.select(id);
        road.setEndPoints(roadMapper.selectEndpoints(id));

        return road;
    }

    public List<Road> getAllRoads() {
        List<Road> roads = roadMapper.selectAll();
        populateEndpoints(roads);

        return roads;
    }

    public void populateEndpoints(List<Road> roads) {
        roads.forEach(road -> selectEndpoints(road));
    }

    public void selectEndpoints(Road road) {
        road.setEndPoints(roadMapper.selectEndpoints(road.getId()));
    }
}
