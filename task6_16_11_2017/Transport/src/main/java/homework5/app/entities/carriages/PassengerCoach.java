package entities.carriages;

import entities.Passenger;
import entities.carriages.Carriage;
import exceptions.OutOfCarRangeException;

import java.util.ArrayList;

public abstract class PassengerCoach extends Carriage {
    private int id;
    private int comfortLevel;
    private ArrayList<Passenger> passengers = new ArrayList<>();

    private int MAX_PASSENGER_AMOUNT;

    public PassengerCoach(int MAX_PASSENGER_AMOUNT, int comfortLevel){
        super();
        this.id = getId();
        this.passengers = new ArrayList<>();
        this.comfortLevel = comfortLevel;
        this.MAX_PASSENGER_AMOUNT = MAX_PASSENGER_AMOUNT;
    }

    public PassengerCoach(int MAX_PASSENGER_AMOUNT, ArrayList<Passenger> passengers, int comfortLevel) throws OutOfCarRangeException{
        this.id = getId();
        this.comfortLevel = comfortLevel;
        if(passengers.size() > MAX_PASSENGER_AMOUNT){
            throw new OutOfCarRangeException("Too much Passengers for" + this.getClass().getSimpleName());
        }
        this.passengers = passengers;
        this.MAX_PASSENGER_AMOUNT = MAX_PASSENGER_AMOUNT;
    }

    public int getComfortLevel() {
        return this.comfortLevel;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public int getPassengerAmount(){
        return this.passengers.size();
    }

    public int getBaggageAmount(){
        int n = 0;
        for(int i = 0; i < passengers.size(); i++){
            n += passengers.get(i).getBaggageUnits();
        }
        return n;
    }

    @Override
    public String toString() {
        return "\n PassengerCoach{" +
                "id=" + id +
                ", comfortLevel=" + comfortLevel +
                ", passengers=\n" + passengers.size() +
                "}";
    }

    public void addPassenger(Passenger passenger)throws OutOfCarRangeException{
        if((this.passengers.size()) == this.MAX_PASSENGER_AMOUNT){
            throw new OutOfCarRangeException();
        }else{
            this.passengers.add(passenger);
        }
    }

}
