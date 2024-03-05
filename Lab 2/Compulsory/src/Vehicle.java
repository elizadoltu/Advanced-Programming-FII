/**
 * @author Eliza - Teodora Doltu
*/

import java.util.*;

public class Vehicle {
    
    private String carName;
    private Depot depot;

    /**
     * 
     * @param name
     */
    public Vehicle(String name, Depot depot) {
        this.carName = name;
        this.depot = depot;
    }

    @Override
    public String toString() {
        return "Vehicle{depot='" + depot + "', carName=" + carName + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Vehicle)) {
            return false;
        }
        Vehicle other = (Vehicle) obj;
        return carName.equals(other.carName);
    }

    public String getCarName() {
      return this.carName;
    }
    public void setCarName(String value) {
      this.carName = value;
    }

    public Depot getDepot() {
      return this.depot;
    }
    public void setDepot(Depot value) {
      this.depot = value;
    }
}
