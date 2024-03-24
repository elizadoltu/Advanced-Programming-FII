<<<<<<< HEAD
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class TravelPlan {
    private Map<Attraction, Pair<LocalTime, LocalTime>> plan;
=======
import java.text.SimpleDateFormat;
import java.util.*;

public class TravelPlan {
    private Map<Attraction, Date> plan;
>>>>>>> e462f99a86d214e9a94918ad916d393d2efaf9eb

    public TravelPlan() {
        plan = new HashMap<>();
    }

<<<<<<< HEAD
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
=======
    public void addVisit(Attraction attraction, Date date) {
        plan.put(attraction, date);
    }

    public void printTravelPlan() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Travel Plan:");
        for (Map.Entry<Attraction, Date> entry : plan.entrySet()) {
            Attraction attraction = entry.getKey();
            Date date = entry.getValue();
            String attractionType = attraction instanceof Visitable ? "Visitable" : "Non-visitable";
            String entryFee = attraction instanceof Payable ? "Entry fee: $" + ((Payable) attraction).getEntryFee() : "No entry fee";
            String visitDate = dateFormat.format(date);
            System.out.println(attraction.name + " - Type: " + attractionType + ", Visit Date: " + visitDate + ", " + entryFee);
        }
    }
}
>>>>>>> e462f99a86d214e9a94918ad916d393d2efaf9eb
