package entities.carriages;

import entities.Passenger;
import entities.carriages.PassengerCoach;
import exceptions.OutOfCarRangeException;

import java.util.ArrayList;

public class SVCar extends PassengerCoach {
    public final int MAX_PASSENGER_AMOUNT = 24;
    private final int comfortLevel = 2;
    private int id;
    private ArrayList<Passenger> passengers;

    public SVCar(){
        super(24, 2);
        this.id = getId();
        this.passengers = getPassengers();
    }

    public SVCar(ArrayList<Passenger> passengers)throws OutOfCarRangeException{
        super(24, passengers, 2);
        this.id = getId();
        this.passengers = getPassengers();
    }

    @Override
    public String toString() {
        return "\nSVCar{" +
                ", comfortLevel=" + comfortLevel +
                ", id=" + id +
                ", passengers=" + passengers.size() +
                '}';
    }
}
