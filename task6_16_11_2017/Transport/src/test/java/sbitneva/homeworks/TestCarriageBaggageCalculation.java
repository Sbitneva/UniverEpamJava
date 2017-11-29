package app;

import entities.Passenger;
import entities.carriages.*;
import factories.*;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class TestCarriageBaggageCalculation {

    ArrayList<Passenger> passengers = new ArrayList<>();
    @Test
    public void testBaggageCalculation(){
        passengers.add(PassengerFactory.create("Vasya", 2));
        passengers.add(PassengerFactory.create("Vasya", 3));
        passengers.add(PassengerFactory.create("Vasya", 1));
        passengers.add(PassengerFactory.create("Vasya", 1));

        int baggageAmount = 0;

        for(int i = 0; i < passengers.size(); i++){
            baggageAmount += passengers.get(i).getBaggageUnits();
        }

        VIPCar vipCar = VIPCarFactory.create(passengers);
        CoupeCar coupeCar = CoupeCarFactory.create(passengers);
        SVCar svCar = SVCarFactory.create(passengers);
        SecondClassSittingCar secondClassSittingCar = SecondClassSittingCarFactory.create(passengers);
        FirstClassSittingCar firstClassSittingCar = FirstClassSittingCarFactory.create(passengers);

        assertTrue(baggageAmount == vipCar.getBaggageAmount());
        assertTrue(baggageAmount == coupeCar.getBaggageAmount());
        assertTrue(baggageAmount == svCar.getBaggageAmount());
        assertTrue(baggageAmount == secondClassSittingCar.getBaggageAmount());
        assertTrue(baggageAmount == firstClassSittingCar.getBaggageAmount());

    }
}
