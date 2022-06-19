package com.solvd.bus.utils.pathfinding;

//El usuario ingresa un valor no entero o fuera del rango de busStop id's.
public class InvalidUserInputException extends Exception {
    public InvalidUserInputException() {
        super();
    }
}

//    public Bus getBusThatConnectTwoStops(BusStop stop1, BusStop stop2) {
//        Bus busThatConnectBusStops = null;
//        Set<Route> route1 = routes.stream().filter(route -> route.getBusStopID() == stop1.getBusStopID()).collect(Collectors.toSet()); //gives info about all de buses that have a stop in this busStopS
//        Set<Route> route2 = routes.stream().filter(route -> route.getBusStopID() == stop2.getBusStopID()).collect(Collectors.toSet());
//
//        for (Route destination : route2) {
//            Long busThatConnectBusStopsID = route1.stream().filter(origin -> origin.getBusID() == destination.getBusStopID()).findFirst().get().getBusID();
//            busThatConnectBusStops = getBusByID(busThatConnectBusStopsID);
//        }
//        return busThatConnectBusStops;
//    }

