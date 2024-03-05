import java.time.LocalTime;

enum ClientType {
    REGULAR,
    PREMIUM
}


public class Client {

    private String name;
    private LocalTime minTime;
    private LocalTime maxTime;
    private ClientType clientType;

    public Client(String name, LocalTime minTime, LocalTime maxTime, ClientType type) {

        this.name = name;
        this.minTime = minTime;
        this.maxTime = maxTime;
        this.clientType = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setMinTime(LocalTime minTime) {
        this.minTime = minTime;
    }

    public LocalTime getMinTime() {
        return this.minTime;
    }

    public void setMaxTime(LocalTime maxTime) {
        this.maxTime = maxTime;
    }

    public LocalTime getMaxTime() {
        return this.maxTime;
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }

    public ClientType getClientType() {
        return this.clientType;
    }

    @Override
    public String toString() {
        return "Client{name='" + name + "', startTime=" + minTime + ", endTime=" + maxTime + ", type=" + clientType + '}';
    }
} 

