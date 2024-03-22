import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator; // Import Comparator
import java.util.Date;
import java.util.List;

public class Trip {
    private String city;
    private LocalDate periodStart;
    private LocalDate periodEnd;
    private List<Attraction> attractions;

    public Trip(String city, LocalDate periodStart, LocalDate periodEnd) {
        this.city = city;
        this.periodStart = periodStart;
        this.periodEnd = periodEnd;
        this.attractions = new ArrayList<>();
    }

    public void addAttraction(Attraction attraction) {
        attractions.add(attraction);
    }

    public List<Attraction> getVisitableNotPayable() {
        List<Attraction> visitableNotPayable = new ArrayList<>();
        for (Attraction attraction : attractions) {
            if (attraction instanceof Visitable && !(attraction instanceof Payable)) {
                visitableNotPayable.add(attraction);
            }
        }
        visitableNotPayable.sort(Comparator.comparing(a -> ((Visitable) a).getOpeningHour(periodStart)));
        return visitableNotPayable;
    }

    public String getCity() {
        return city;
    }

    public LocalDate getStart() {
        return periodStart;
    }

    public LocalDate getEnd() {
        return periodEnd;
    }

    public List<Attraction> getAttractions() {
        return attractions;
    }
    @Override
    public String toString() {
        return "Trip{" +
                "city='" + city + '\'' +
                ", start=" + periodStart +
                ", end=" + periodEnd +
                '}';
    }
}