package com.solvd.bus.utils;

import com.solvd.bus.dao.*;
import com.solvd.bus.domain.Bus;
import com.solvd.bus.domain.BusStop;
import com.solvd.bus.domain.City;
import com.solvd.bus.domain.Road;
import org.apache.ibatis.session.SqlSession;


public class MyBatisFactory extends AbstractFactory{

    private static SessionFactory factory = SessionFactory.getInstance();
    private static SqlSession session = factory.getFactory().openSession();

    public IDao<?> getMapper(String mapper) {
        switch (mapper.toLowerCase()) {
            case "bus" :
                IDao<Bus> busMapper = session.getMapper(IBusDao.class);
                return busMapper;
            case "stop" :
                IDao<BusStop> busStopMapper = session.getMapper(IBusStopsDao.class);
                return busStopMapper;
            case "road" :
                IDao<Road> roadMapper = session.getMapper(IRoadDao.class);
                return roadMapper;
            case "city" :
                IDao<City> cityMapper = session.getMapper(ICityDao.class);
                return cityMapper;
        }
        return null;
    }

    public static SqlSession getSession() {
        return session;
    }
}
