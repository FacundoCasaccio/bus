package com.solvd.bus.service;

import com.solvd.bus.dao.IBusDao;
import com.solvd.bus.domain.Bus;
import com.solvd.bus.utils.AbstractFactory;
import com.solvd.bus.utils.MyBatisFactory;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BusService {

    SqlSession session = MyBatisFactory.getSession();
    private MyBatisFactory factory = (MyBatisFactory) AbstractFactory.getFactory("mybatis");

    private IBusDao busMapper = (IBusDao) factory.getMapper("bus");

    public Bus getBusById(int id) {
        Bus bus = busMapper.select(id);
        bus.setBusStops(busMapper.selectAllBusStopsByBusID(id));
        return bus;
    }

    public List<Bus> getAllBuses() {
        List<Bus> buses = busMapper.selectAll();
        return buses;
    }

}
