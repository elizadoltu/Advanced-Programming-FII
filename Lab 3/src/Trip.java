import java.time.LocalDate;
import java.util.ArrayList;
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

    @Override
    public String toString() {
        return "Trip{" +
                "city='" + city + '\'' +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
