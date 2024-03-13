import java.time.LocalDate;
import java.time.LocalTime;

public class Statue extends Attraction implements Visitable, Payable {

    private double ticketPrice;
    private LocalTime localTime;
    private int height;

    public Statue(String name, LocalTime localTime, double ticketPrice, int height) {
        super(name);
        this.localTime = localTime;
        this.ticketPrice = ticketPrice;
        this.height = height;
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
        return "Statue{name='" + name + "', ticketPrice='" + ticketPrice + "', height=" + height + "}";
    }
    // getters, setters, toString, equals
}
