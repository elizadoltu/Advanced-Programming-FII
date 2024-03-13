import java.time.LocalDate;
import java.time.LocalTime;

public class Church extends Attraction implements Visitable, Payable{
    
    private double ticketPrice;
    private LocalTime localTime;
    private int buildAge;

    public Church(String name, LocalTime localTime, double ticketPrice, int buildAge) {
        super(name);
        this.localTime = localTime;
        this.ticketPrice = ticketPrice;
        this.buildAge = buildAge;
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
    
    public String toString() {
        return "Church{name='" + name + "', ticketPrice='" + ticketPrice + "', build year=" + buildAge + "}";
    }
    // getters, setters, toString, equals
}
