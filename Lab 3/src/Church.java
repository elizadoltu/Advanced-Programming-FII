import java.time.LocalTime;
import java.time.LocalDate;
import java.util.*;

public class Church extends Attraction implements Visitable, Payable{
    
    private double ticketPrice;
    private LocalTime localTime;
    private int buildAge;
    private Map<LocalDate, TimeInterval> timetable;

    public Church(String name, LocalTime localTime, double ticketPrice, int buildAge) {
        super(name);
        this.localTime = localTime;
        this.ticketPrice = ticketPrice;
        this.buildAge = buildAge;
        this.timetable = new HashMap<>();
    }
    @Override
    public double getTicketPrice() {
        return this.ticketPrice;
    }

    @Override
    public String getName() {
        return this.name;
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
        return "Church{name='" + name + "', ticketPrice='" + ticketPrice + "', build year=" + buildAge + "}";
    }

    public void addToTimeTable(LocalDate date, TimeInterval timeInterval) {
        timetable.put(date, timeInterval);
    }

    @Override
    public Map<LocalDate, TimeInterval> getTimetable() {
        return timetable;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Church)) {
            return false;
        }
        Church other = (Church) obj;
        return name.equals(other.name);
    }
    // getters, setters, toString, equals
}
