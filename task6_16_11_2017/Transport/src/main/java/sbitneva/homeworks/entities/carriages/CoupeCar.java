package entities.carriages;

import entities.Passenger;
import exceptions.OutOfCarRangeException;

import java.util.ArrayList;

public class CoupeCar extends PassengerCoach {
    public final int MAX_PASSENGER_AMOUNT = 48;
    private final int comfortLevel = 3;
    private int id;
    private ArrayList<Passenger> passengers = new ArrayList<>();

    public CoupeCar(){
        super(48, 3);
        this.id = getId();
        this.passengers = getPassengers();
    }

    public CoupeCar(ArrayList<Passenger> passengers)throws OutOfCarRangeException{
        super(48, passengers, 3);
        this.id = getId();
        this.passengers = getPassengers();
    }

    @Override
    public String toString() {
        return "\nCoupeCar{" +
                "comfortLevel=" + comfortLevel +
                ", id=" + id +
                ", passengers=" + passengers.size() +
                '}';
    }
}
