package com.solvd.bus.dao;

import java.util.List;

public interface IDao<T> {

    T select(int id);

    List<T> selectAll();
}
