import java.time.LocalDate;
import java.time.LocalTime;

public class Concert extends Attraction implements Visitable, Payable {

    private double ticketPrice;
    private LocalTime localTime;
    private int startYear;

    public Concert(String name, LocalTime localTime, double ticketPrice, int startYear) {
        super(name);
        this.localTime = localTime;
        this.ticketPrice = ticketPrice;
        this.startYear = startYear;
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
}
