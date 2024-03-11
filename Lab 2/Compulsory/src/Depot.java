
/**
 * @author Eliza Doltu
 */

 
public class Depot {
    
    private String name;
    private Vehicle[] vehicles;

    public Depot(String name) {
        this.name = name;
    }
    
    public String getName() {
      return this.name;
    }
    public void setName(String value) {
      this.name = value;
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("Depot{name='").append(name).append("', vehicles=[");
      if (vehicles != null && vehicles.length > 0) {
          for (int i = 0; i < vehicles.length; i++) {
              sb.append(vehicles[i].getCarName());
              if (i < vehicles.length - 1) {
                  sb.append(", ");
              }
          }
      } else {
          sb.append("No vehicles");
      }
      sb.append("]}");
      return sb.toString();
    }

    /**
     * 
     * @param vehicles
     */
    public void setVehicles(Vehicle... vehicles) {
      this.vehicles = vehicles;
      for (Vehicle v : vehicles) {
        v.setDepot(this); 
      }
    }

    public Vehicle[] getVehicles() {
      return vehicles;
    }
    // to string 
    // equals
    // @Override
    // public boolean equals(Object obj) {
    //     if (obj == null || !(obj instanceof Vehicle)) {
    //         return false;
    //     }
    //     Vehicle other = (Vehicle) obj;
    //     return 
    // }

    @Override
    public boolean equals(Object obj) {
      if (obj == null || !(obj instanceof Depot)) {
        return false; 
      }
      Depot other = (Depot) obj;
      return name.equals(other.name);
    }
}
