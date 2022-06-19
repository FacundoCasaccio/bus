package com.solvd.bus.dao;

import com.solvd.bus.domain.Bus;

import java.util.List;

public interface IBusDao extends IDao<Bus>{

    @Override
    Bus select(int id);

    @Override
    List<Bus> selectAll();
}
