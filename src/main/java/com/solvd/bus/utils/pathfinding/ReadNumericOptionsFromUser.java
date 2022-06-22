package com.solvd.bus.utils.pathfinding;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ReadNumericOptionsFromUser {
    private static final Logger LOGGER = LogManager.getLogger(ReadNumericOptionsFromUser.class);
    private static Scanner sn;

    private Integer readOptionFromUser(List<Integer> expectedValues) throws InvalidUserInputException {
        int option;
        sn = new Scanner(System.in);
//        try (Scanner sn = new Scanner(System.in)) {
        option = sn.nextInt();
        if (!expectedValues.contains(option)) {
            throw new InvalidUserInputException();
        }
        //}
        return option;
    }

    public Integer optionFromUser(List<Integer> expectedValues) {
        while (true) {
            try {
                return readOptionFromUser(expectedValues);
            } catch (InvalidUserInputException | InputMismatchException e) {
                LOGGER.error("Invalid option entered, please try again", e);
                continue;
            }
        }
    }
}

