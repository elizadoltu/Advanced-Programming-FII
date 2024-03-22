import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Map;

public class Statue extends Attraction implements Visitable {
    private Map<LocalDate, Pair<LocalTime, LocalTime>> visitingTimetable;
    private int height;
    private double ticketPrice;

    public Statue(String name, Map<LocalDate, Pair<LocalTime, LocalTime>> visitingTimetable, double ticketPrice ,int height) {
        super(name);
        this.visitingTimetable = visitingTimetable;
        this.height = height;
        this.ticketPrice = ticketPrice;
    }

    @Override
    public Map<LocalDate, Pair<LocalTime, LocalTime>> getVisitingTimetable() {
        return visitingTimetable;
    }

    @Override
    public String toString() {
        return "Statue{name='" + name + "', ticketPrice='" + ticketPrice + "', height=" + height + "}";
    }
}