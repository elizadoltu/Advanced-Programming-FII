package src;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Eliza - Teodora Doltu
 */

public class Problem {

    private Depot[] depots;
    private Client[] clients;
    private Vehicle[] vehicles;

    public void setDepots(Depot[] depots) {
        this.depots = depots;
    }

    public void setClients(Client[] clients) {
        this.clients = clients;
    }

    public void setVehicles(Vehicle[] vehicles) {
        this.vehicles = vehicles;
    }

    /**
     * 
     * @return allVehicles
     */
    public Vehicle[] getVehicles() {

        List<Vehicle> allVehicles = new ArrayList<>();
        for (Depot depot : depots) {
            for (Vehicle vehicle : depot.getVehicles()) {
                allVehicles.add(vehicle);
            }
        }
        return allVehicles.toArray(new Vehicle[0]);
    }

    public Client[] getClients() {
        return clients;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Depots:\n");
        if (depots != null) {
            for (Depot depot : depots) {
                sb.append(depot).append("\n");
            }
        } else {
            sb.append("No depots found.\n");
        }
        sb.append("Clients:\n");
        if (clients != null) {
            for (Client client : clients) {
                sb.append(client).append("\n");
            }
        } else {
            sb.append("No clients found.\n");
        }
        sb.append("Vehicles:\n");
        if (vehicles != null) {
            for (Vehicle vehicle : vehicles) {
                sb.append(vehicle).append("\n");
            }
        } else {
            sb.append("No vehicles found.\n");
        }
        return sb.toString();
    }
    
}