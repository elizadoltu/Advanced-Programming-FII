
import java.time.LocalTime;

/**
 * @author Eliza - Teodora Doltu
 */


public class App {
    
    /**
     * @param args
     */
    public static void main(String[] args) {
       
        Problem pb = new Problem();

        Client client1 = new Client("John", LocalTime.of(8, 0), LocalTime.of(12, 0), ClientType.REGULAR);
        Client client2 = new Client("Michael", LocalTime.of(9, 0), LocalTime.of(13, 0), ClientType.PREMIUM);

        Depot depot1 = new Depot("Targu Ocna");
        Depot depot2 = new Depot("Bacau");

        Vehicle[] vehicles = new Vehicle[2];
        vehicles[0] = new Drone("Drone 1", depot1, 100);
        vehicles[1] = new Truck("Truck 1", depot1, 34);

        depot1.setVehicles(vehicles);

        pb.setClients(new Client[]{client1, client2});
        pb.setDepots(new Depot[]{depot1, depot2});
        pb.setVehicles(vehicles);
        String allVehicles = pb.getVehicles();

        System.out.println(pb);
        System.out.println("All vehicles:");
        System.out.println(allVehicles);
    }
}
