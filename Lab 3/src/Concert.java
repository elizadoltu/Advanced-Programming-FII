import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Map;

public class Concert extends Attraction implements Visitable, Payable {
    private Map<LocalDate, Pair<LocalTime, LocalTime>> visitingTimetable;
    private double entryFee;
    private int startYear;

    public Concert(String name, Map<LocalDate, Pair<LocalTime, LocalTime>> visitingTimetable, double entryFee, int startYear) {
        super(name);
        this.visitingTimetable = visitingTimetable;
        this.entryFee = entryFee;
        this.startYear = startYear;
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
        return "Concert{name='" + name + "', ticketPrice='" + entryFee + "', startYear=" + startYear + "}";
    }
<<<<<<< HEAD

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Concert)) {
            return false;
        }
        Concert other = (Concert) obj;
        return name.equals(other.name);
    }
=======
>>>>>>> e462f99a86d214e9a94918ad916d393d2efaf9eb
}