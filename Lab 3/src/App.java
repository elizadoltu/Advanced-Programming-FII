import java.time.LocalDate;
import java.time.LocalTime;

public class App {
    public static void main(String[] args) {
       
        Church church = new Church("St. Patrick's Cathedral", LocalTime.of(9, 0), 10.0, 1878);
        Concert concert = new Concert("Rock Concert", LocalTime.of(20, 0), 50.0, 2024);
        Statue statue = new Statue("Statue of Liberty", LocalTime.of(10, 0), 0.0, 93);
        
        Trip trip = new Trip("New York City", LocalDate.of(2024, 4, 1), LocalDate.of(2024, 4, 5));
        trip.addAttraction(church);
        trip.addAttraction(concert);
        trip.addAttraction(statue);

        System.out.println("Trip to " + trip.getCity() + " from " + trip.getStart() + " to " + trip.getEnd() + ":");
        System.out.println(trip);
        System.out.println("Attractions:");
        for (Attraction attraction : trip.getAttractions()) {
            System.out.println(attraction);
        }
    }
}
