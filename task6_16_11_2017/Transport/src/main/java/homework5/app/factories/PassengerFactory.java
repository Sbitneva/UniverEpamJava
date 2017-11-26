package homework5.app.factories;

import homework5.app.entities.Passenger;

import java.util.ArrayList;
import java.util.Random;

public class PassengerFactory {

    public static Passenger create(String name, int baggageUnits){
        return new Passenger(name, baggageUnits);
    }

    public static Passenger createRandom(){
        Random r = new Random();
        Passenger passenger = new Passenger();
        passenger.setName("Passenger " + passenger.getId());
        passenger.setBaggageUnits(r.nextInt(3) + 1);
        return passenger;
    }
}
