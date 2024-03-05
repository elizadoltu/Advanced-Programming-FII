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

    public Vehicle[] getVehicles() {
      return this.vehicles;
    }
    public void setVehicles(Vehicle[] value) {
      this.vehicles = value;
    }

    @Override
    public String toString() {
        return "Depot{name='" + name + "'}";
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
}
