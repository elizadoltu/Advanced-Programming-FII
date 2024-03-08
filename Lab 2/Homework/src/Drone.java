package src;
/**
 * @author Eliza - Teodora Doltu
 */

public class Drone extends Vehicle{

    protected int flightDuration;

    /**
     * 
     * @param droneName
     * @param depot
     * @param flightDuration
     */
    public Drone(String droneName, Depot depot, int flightDuration) {
        super(droneName, depot);
        this.flightDuration = flightDuration;
    }

    public void setFlightDuration(int duration) {
        this.flightDuration = duration;
    }

    /**
     * 
     * @return flightDuration
     */
    public int getFlightDuration() {
        return this.flightDuration;
    }
    @Override
    public String toString() {
        return "Drone{name='" + carName + "', depot='" + depot + "', flight duration=" + flightDuration + "}";
    }
}
