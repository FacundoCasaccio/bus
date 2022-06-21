package com.solvd.bus.utils;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.bus.domain.Trip;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class writerJSON {

    private static final Logger LOGGER = LogManager.getLogger(writerXML.class);
    private Trip trip;

    public writerJSON(Trip trip) {
        this.trip = trip;
    }

    public void writeJSON(){

        ObjectMapper mapper = new ObjectMapper();

        try {
            File writingFile = new File("src/main/resources/JSON/trip.json");
            mapper.writerWithDefaultPrettyPrinter().writeValue(writingFile, trip);
        } catch (IOException e){
            LOGGER.error(e);
        }
    }
}
