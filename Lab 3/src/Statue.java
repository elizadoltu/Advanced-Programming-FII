import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class Statue extends Attraction implements Visitable, Payable {

    private double ticketPrice;
    private LocalTime localTime;
    private int height;
    private Map<LocalDate, TimeInterval> timetable;

    public Statue(String name, LocalTime localTime, double ticketPrice, int height) {
        super(name);
        this.localTime = localTime;
        this.ticketPrice = ticketPrice;
        this.height = height;
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
        return "Statue{name='" + name + "', ticketPrice='" + ticketPrice + "', height=" + height + "}";
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
        if (obj == null || !(obj instanceof Statue)) {
            return false;
        }
        Statue other = (Statue) obj;
        return name.equals(other.name);
    }
    // getters, setters, toString, equals
}
