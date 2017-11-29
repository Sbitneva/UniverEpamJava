package factories;

import entities.Passenger;
import entities.carriages.SVCar;
import exceptions.OutOfCarRangeException;

import java.util.ArrayList;
import java.util.Random;

public class SVCarFactory {

    public static SVCar create(ArrayList<Passenger> passengers){
        SVCar svCar = null;
        try{
            svCar = new SVCar(passengers);
        }catch (OutOfCarRangeException e){
            System.out.print(e.getMessage());
        }
        return svCar;
    }

    public static SVCar createRandom() {
        Random r = new Random();
        SVCar svCar = new SVCar();
        int passAmount = r.nextInt(svCar.MAX_PASSENGER_AMOUNT + 1);

        for (int i = 0; i < passAmount; i++) {
            try {
                svCar.addPassenger(PassengerFactory.createRandom());
            } catch (OutOfCarRangeException e) {
                System.out.print(e.getMessage());
            }
        }
        return svCar;
    }
}
