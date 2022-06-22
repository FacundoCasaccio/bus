package com.solvd.bus.utils.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.bus.domain.Trip;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class WriterJSON {
    private static final Logger LOGGER = LogManager.getLogger(WriterJSON.class);
    private Trip trip;

    public WriterJSON(Trip trip) {
        this.trip = trip;
    }

    public void writeJSON() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            File writingFile = new File("src/main/resources/json/trip.json");
            mapper.writerWithDefaultPrettyPrinter().writeValue(writingFile, trip);
        } catch (IOException e) {
            LOGGER.error(e);
        }
    }
}


