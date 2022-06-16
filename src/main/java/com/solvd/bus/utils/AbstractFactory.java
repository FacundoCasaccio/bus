package com.solvd.bus.utils;

public class AbstractFactory {

    private static MyBatisFactory myBatisFactory = new MyBatisFactory();

    public static AbstractFactory getFactory(String factory) {

        switch (factory.toLowerCase()) {
            case "mybatis":
                return myBatisFactory;
        }
        return null;
    }
}
