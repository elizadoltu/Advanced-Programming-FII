package src;
/**
 * @author Eliza - Teodora Doltu
 */

public class Truck extends Vehicle {

    protected int capacity;

    /**
     * 
     * @param truckName
     * @param depot
     * @param capacity
     */
    public Truck(String truckName, Depot depot, int capacity) {
        super(truckName, depot);
        this.capacity = capacity;
    }

    public void setCapacityTruck(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacityTruck(int capacity) {
        return this.capacity;
    }

    @Override
    public String toString() {
        return "Truck{name='" + carName + "', depot='" + depot + "', capacity=" + capacity + "}";
    }
}
