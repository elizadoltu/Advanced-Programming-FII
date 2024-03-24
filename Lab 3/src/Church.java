import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Map;

public class Church extends Attraction implements Visitable, Payable {
    private Map<LocalDate, Pair<LocalTime, LocalTime>> visitingTimetable;
    private double entryFee;
    private int buildAge;

    public Church(String name, Map<LocalDate, Pair<LocalTime, LocalTime>> visitingTimetable, double entryFee, int buildAge) {
        super(name);
        this.visitingTimetable = visitingTimetable;
        this.entryFee = entryFee;
        this.buildAge = buildAge;
    }

    @Override
    public Map<LocalDate, Pair<LocalTime, LocalTime>> getVisitingTimetable() {
        return visitingTimetable;
    }

    @Override
    public double getEntryFee() {
        return entryFee;
    }

    @Override
    public String toString() {
        return "Church{name='" + name + "', ticketPrice='" + entryFee + "', build year=" + buildAge + "}";
    }
<<<<<<< HEAD
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Church)) {
            return false;
        }
        Church other = (Church) obj;
        return name.equals(other.name);
    }
=======
>>>>>>> e462f99a86d214e9a94918ad916d393d2efaf9eb
}