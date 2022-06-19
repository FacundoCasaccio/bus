package com.solvd.bus;

import com.solvd.bus.dao.IBusDao;
import com.solvd.bus.dao.IBusStopsDao;
import com.solvd.bus.dao.ICityDao;
import com.solvd.bus.domain.Bus;
import com.solvd.bus.domain.BusStop;
import com.solvd.bus.domain.City;
import com.solvd.bus.utils.AbstractFactory;
import com.solvd.bus.utils.MyBatisFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Runner {

    private static final Logger LOGGER = LogManager.getLogger(Runner.class);

    public static void main(String[] args) {
        SqlSession session = MyBatisFactory.getSession();
        MyBatisFactory myBatisFactory = (MyBatisFactory) AbstractFactory.getFactory("mybatis");

        IBusStopsDao busStopMapper = (IBusStopsDao) myBatisFactory.getMapper("stop");

        BusStop busStop = busStopMapper.select(1);
        busStop.setRoads(busStopMapper.selectRoadConnections(1));
        //LOGGER.info(busStop);
        //LOGGER.info(busStop.getRoads());

        IBusDao busMapper = (IBusDao) myBatisFactory.getMapper("bus");

        Bus bus = busMapper.select(1);
        LOGGER.info(bus);

        ICityDao cityMapper = (ICityDao) myBatisFactory.getMapper("city");

        City city = cityMapper.select(1);
        city.setBusStops(cityMapper.selectBusStops(1));
        city.setTerminal(cityMapper.selectTerminal(1));

        LOGGER.info(city);
    }
}
