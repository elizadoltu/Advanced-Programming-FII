import java.text.SimpleDateFormat;
import java.util.*;

public class TravelPlan {
    private Map<Attraction, Date> plan;

    public TravelPlan() {
        plan = new HashMap<>();
    }

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