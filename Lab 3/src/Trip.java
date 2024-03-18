import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Trip {
    private String city;
    private LocalDate start;
    private LocalDate end;
    private List<Attraction> attractions = new ArrayList<>();

    public Trip(String city, LocalDate start, LocalDate end) {
        this.city = city;
        this.start = start;
        this.end = end;
        this.attractions = new ArrayList<>();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public List<Attraction> getAttractions() {
        return attractions;
    }

    public void addAttraction(Attraction attraction) {
        attractions.add(attraction);
    }

    // New method to display visitable locations that are not payable, sorted by opening hour
    public void displayVisitableNotPayable() {
        List<Visitable> visitableNotPayable = new ArrayList<>();
        for (Attraction attraction : attractions) {
            if (attraction instanceof Visitable && !(attraction instanceof Payable)) {
                visitableNotPayable.add((Visitable) attraction);
            }
        }
        visitableNotPayable.sort(Comparator.comparing(Visitable::getOpeningHour));
        System.out.println("Visitable locations that are not payable, sorted by opening hour:");
        for (Visitable attraction : visitableNotPayable) {
            System.out.println("Name: " + attraction.getName() + ", Opening Hour: " + attraction.getOpeningHour());
        }
    }

    @Override
    public String toString() {
        return "Trip{" +
                "city='" + city + '\'' +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
