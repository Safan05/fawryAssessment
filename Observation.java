import java.util.Date;
public class Observation{
    private final String plateNumber;
    private final Date date;
    private final CarType carType;
    private final int speed;
    private final boolean seatbeltFastened;

    public Observation(String plateNumber, Date date, CarType carType, int speed, boolean seatbeltFastened) {
        this.plateNumber = plateNumber;
        this.date = date;
        this.carType = carType;
        this.speed = speed;
        this.seatbeltFastened = seatbeltFastened;
    }

    public String getPlateNumber() { return plateNumber; }
    public CarType getCarType() { return carType; }
    public int getSpeed() { return speed; }
    public boolean isSeatbeltFastened() { return seatbeltFastened; }
}