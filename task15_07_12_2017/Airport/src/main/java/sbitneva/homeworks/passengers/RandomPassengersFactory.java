package sbitneva.homeworks.passengers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class RandomPassengersFactory {
    public static Queue<Passenger> create(){
        Queue<Passenger> passengersQ = new LinkedList<>();
        Random r = new Random();
        int setSize = r.nextInt(200);
        for(int i = 0; i <setSize; i++) {
            Passenger passenger = new Passenger();
            passenger.setName("Passenger # " + passenger.getId());
            passengersQ.add(passenger);
        }
        return passengersQ;
    }
}
