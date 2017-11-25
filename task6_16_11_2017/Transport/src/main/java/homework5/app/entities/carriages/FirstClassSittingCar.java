package homework5.app.entities.carriages;

import homework5.app.entities.Passenger;
import homework5.app.exceptions.OutOfCarRangeException;

import java.util.ArrayList;

public class FirstClassSittingCar extends PassengerCoach{
    public final int MAX_PASSENGER_AMOUNT = 20;
    private final int comfortLevel = 4;
    private int id;
    private ArrayList<Passenger> passengers = new ArrayList<>();

    public FirstClassSittingCar(){
        super(20, 4);
        this.id = getId();
        this.passengers = getPassengers();
    }

    public FirstClassSittingCar(ArrayList<Passenger> passengers)throws OutOfCarRangeException{
        super(20, passengers, 4);
        this.id = getId();
        this.passengers = getPassengers();
    }

    @Override
    public String toString() {
        return "\nFirstClassSittingCar{" +
                "comfortLevel=" + comfortLevel +
                ", id=" + id +
                ", passengers=" + passengers.size() +
                '}';
    }
}
