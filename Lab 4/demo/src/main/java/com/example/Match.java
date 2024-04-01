package com.example;

class Match {
    private Driver driver;
    private Passenger passenger;

    public Match(Driver driver, Passenger passenger) {
        this.driver = driver;
        this.passenger = passenger;
    }

    @Override
    public String toString() {
        if (driver != null && passenger != null) {
            return driver.getName() + " (going to " + driver.getDestination() + ") will pick up " + passenger.getName()
                    + " at " + passenger.getDestination();
        } else {
            return "Invalid match";
        }
    }
}
