import java.time.LocalTime;

class TimeInterval extends Pair<LocalTime, LocalTime> {

    public TimeInterval(LocalTime starTime, LocalTime endTime) {
        super(starTime, endTime);
    }

    @Override
    public String toString() {
        return getFirst() + " - " + getSecond();
    }
}
