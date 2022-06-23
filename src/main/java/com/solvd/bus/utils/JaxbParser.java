package com.solvd.bus.utils;

import com.solvd.bus.domain.Trip;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;

public class JaxbParser {

    public static void marshallTrip(Trip trip) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Trip.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(trip, new File("src/main/resources/xml/trip.xml"));
    }

}
