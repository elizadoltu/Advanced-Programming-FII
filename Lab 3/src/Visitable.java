import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

public interface Visitable {
    Map<LocalDate, Pair<LocalTime, LocalTime>> getVisitingTimetable(); // Map of visiting timetable
    default LocalTime getOpeningHour(LocalDate date) {
        Map<LocalDate, Pair<LocalTime, LocalTime>> timetable = getVisitingTimetable();
        Pair<LocalTime, LocalTime> timePair = timetable.get(date);
        return timePair != null ? timePair.first : null;
    }
}
