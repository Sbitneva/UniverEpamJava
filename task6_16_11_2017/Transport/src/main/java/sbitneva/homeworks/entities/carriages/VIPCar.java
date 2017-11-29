package entities.carriages;

import entities.Passenger;
import exceptions.OutOfCarRangeException;

import java.util.ArrayList;

public class VIPCar extends PassengerCoach{
    public final int MAX_PASSENGER_AMOUNT = 4;
    private final int comfortLevel = 1;
    private int id;
    private ArrayList<Passenger> passengers;

    public VIPCar() {
        super(4, 1);
        this.id = getId();
        this.passengers = new ArrayList<>();
    }
    public VIPCar(ArrayList<Passenger> passengers)throws OutOfCarRangeException{
        super(4, passengers, 1);
        this.id = getId();
    }

    @Override
    public int getComfortLevel() {
        return super.getComfortLevel();
    }

    @Override
    public ArrayList<Passenger> getPassengers() {
        return super.getPassengers();
    }

    @Override
    public int getPassengerAmount() {
        return super.getPassengerAmount();
    }

    @Override
    public int getBaggageAmount() {
        return super.getBaggageAmount();
    }

    @Override
    public String toString() {
        return "\nVIPCar{" +
                "MAX_PASSENGER_AMOUNT=" + MAX_PASSENGER_AMOUNT +
                ", comfortLevel=" + comfortLevel +
                ", id=" + id +
                ", passengers=" + passengers.size() +
                '}';
    }
}
