package com.dillian.initiateservice.exceptions;

public class SolarPanelCapacityException extends Exception {

    private static final String message = "Solar panel capacity reached";

    public SolarPanelCapacityException() {
        super(message);
    }
}
