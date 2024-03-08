import java.time.LocalTime;

/**
 * @author Eliza - Teodora Doltu
 */


public class App {
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        Depot depot = new Depot("Depot A");
        Vehicle vehicle = new Vehicle("Ford Mustang", depot);
        Client regularClient = new Client("Regular Client 1", LocalTime.of(9, 0), LocalTime.of(12, 0), ClientType.REGULAR);
        Client premiumClient = new Client("Premium Client 1", LocalTime.of(10, 0), LocalTime.of(15, 0), ClientType.PREMIUM);

        System.out.println(depot);
        System.out.println(vehicle);
        System.out.println(regularClient);
        System.out.println(premiumClient);

    }
}