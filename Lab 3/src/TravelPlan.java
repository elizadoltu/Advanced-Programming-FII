import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class TravelPlan {
    private Map<Attraction, Pair<LocalTime, LocalTime>> plan;

    public TravelPlan() {
        plan = new HashMap<>();
    }

    public void addVisit(Attraction attraction, Pair<LocalTime, LocalTime> timePair) {
        plan.put(attraction, timePair);
    }

    public void printTravelPlan() {
        System.out.println("Travel Plan:");

        for (Attraction attraction : plan.keySet()) {
            Pair<LocalTime, LocalTime> timePair = plan.get(attraction);

            String attractionType = attraction instanceof Visitable ? "Visitable" : "Non-visitable";

            String entryFee = attraction instanceof Payable ? "Entry fee: $" + ((Payable) attraction).getEntryFee()
                    : "No entry fee";

            String openingHour = timePair != null ? timePair.first.toString() : "Unknown";
            String closingHour = timePair != null ? timePair.second.toString() : "Unknown";

            System.out.println(attraction.name + " - Type: " + attractionType +
                    ", Opening Hour: " + openingHour + ", Closing Hour: " + closingHour +
                    ", " + entryFee);
        }
    }
}
