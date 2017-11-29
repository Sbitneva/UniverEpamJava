package factories;

import entities.Passenger;
import entities.carriages.FirstClassSittingCar;
import exceptions.OutOfCarRangeException;

import java.util.ArrayList;
import java.util.Random;

public class FirstClassSittingCarFactory {

    public static FirstClassSittingCar create(ArrayList<Passenger> passengers){
        FirstClassSittingCar firstClassSittingCar = null;
        try{
            firstClassSittingCar = new FirstClassSittingCar(passengers);
        }catch (OutOfCarRangeException e){
            System.out.print(e.getMessage());
        }
        return firstClassSittingCar;
    }

    public static FirstClassSittingCar createRandom() {
        Random r = new Random();
        FirstClassSittingCar firstClassSittingCar = new FirstClassSittingCar();
        int passAmount = r.nextInt(firstClassSittingCar.MAX_PASSENGER_AMOUNT + 1);

        for (int i = 0; i < passAmount; i++) {
            try {
                firstClassSittingCar.addPassenger(PassengerFactory.createRandom());
            } catch (OutOfCarRangeException e) {
                System.out.print(e.getMessage());
            }
        }
        return firstClassSittingCar;
    }
}
