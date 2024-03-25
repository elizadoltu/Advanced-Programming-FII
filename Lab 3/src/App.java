import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

public class App {
        public static void main(String[] args) {
                // Creating visiting timetables
                Map<LocalDate, Pair<LocalTime, LocalTime>> churchTimetable = new HashMap<>();
                churchTimetable.put(LocalDate.of(2024, 4, 1), new Pair<>(LocalTime.of(9, 0), LocalTime.of(17, 0)));

                Map<LocalDate, Pair<LocalTime, LocalTime>> concertTimetable = new HashMap<>();
                concertTimetable.put(LocalDate.of(2024, 4, 2), new Pair<>(LocalTime.of(20, 0), LocalTime.of(23, 0)));

                Map<LocalDate, Pair<LocalTime, LocalTime>> statueTimetable = new HashMap<>();
                statueTimetable.put(LocalDate.of(2024, 4, 3), new Pair<>(LocalTime.of(10, 0), LocalTime.of(18, 0)));

                // Creating attractions
                Church church = new Church("St. Patrick's Cathedral", churchTimetable, 10.0, 1878);
                Concert concert = new Concert("Rock Concert", concertTimetable, 50.0, 2024);
                Statue statue = new Statue("Statue of Liberty", statueTimetable, 0.0, 93);

                Trip trip = new Trip("New York City", LocalDate.of(2024, 4, 1), LocalDate.of(2024, 4, 5));
                trip.addAttraction(church);
                trip.addAttraction(concert);
                trip.addAttraction(statue);

                // Displaying trip information
                System.out.println("Trip to " + trip.getCity() + " from " + trip.getStart() + " to " + trip.getEnd()
                                + ":");
                System.out.println("Attractions:");
                for (Attraction attraction : trip.getAttractions()) {
                        System.out.println(attraction);
                }

                System.out.println("Visitable attractions that are not payable:");
                List<Attraction> visitableNotPayable = trip.getVisitableNotPayable();
                for (Attraction attraction : visitableNotPayable) {
                        System.out.println(attraction);
                }

                TravelPlan travelPlan = new TravelPlan();
                travelPlan.addVisit(church, new Pair<>(LocalTime.of(9, 0), LocalTime.of(17, 0)));
                travelPlan.addVisit(concert, new Pair<>(LocalTime.of(20, 0), LocalTime.of(23, 0)));
                travelPlan.addVisit(statue, new Pair<>(LocalTime.of(10, 0), LocalTime.of(18, 0)));

                travelPlan.printTravelPlan();
        }
}
