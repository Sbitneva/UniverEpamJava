package homework5.app.entities.carriages;

import homework5.app.entities.Passenger;
import homework5.app.exceptions.OutOfCarRangeException;

import java.util.ArrayList;

public class SecondClassSittingCar extends PassengerCoach{
    public final int MAX_PASSENGER_AMOUNT = 60;
    private final int comfortLevel = 5;
    private ArrayList<Passenger> passengers;
    private int id;

    public SecondClassSittingCar(){
        super(60, 5);
        this.id = getId();
        this.passengers = getPassengers();
    }

    public SecondClassSittingCar(ArrayList<Passenger> passengers)throws OutOfCarRangeException{
        super(60, passengers, 5);
        this.id = getId();
        this.passengers = getPassengers();
    }

    @Override
    public String toString() {
        return "\nSecondClassSittingCar{" +
                "comfortLevel=" + comfortLevel +
                ", passengers=" + passengers.size() +
                ", id=" + id +
                '}';
    }
}
