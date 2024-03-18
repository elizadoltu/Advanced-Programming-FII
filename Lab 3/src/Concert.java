import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class Concert extends Attraction implements Visitable, Payable {

    private double ticketPrice;
    private LocalTime localTime;
    private int startYear;
    private Map<LocalDate, TimeInterval> timetable;

    public Concert(String name, LocalTime localTime, double ticketPrice, int startYear) {
        super(name);
        this.localTime = localTime;
        this.ticketPrice = ticketPrice;
        this.startYear = startYear;
        this.timetable = new HashMap<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getTicketPrice() {
        return this.ticketPrice;
    }

    @Override
    public LocalTime getOpeningHour() {
        return this.localTime;
    }

    public void setTicketPrice(double price) {
        this.ticketPrice = price;
    }

    @Override
    public String toString() {
        return "Concert{name='" + name + "', ticketPrice='" + ticketPrice + "', startYear=" + startYear + "}";
    }
    // getters, setters, toString, equals
    public void addToTimeTable(LocalDate date, TimeInterval timeInterval) {
        timetable.put(date, timeInterval);
    }

    public Map<LocalDate, TimeInterval> getTimetable() {
        return timetable;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Concert)) {
            return false;
        }
        Concert other = (Concert) obj;
        return name.equals(other.name);
    }
}
