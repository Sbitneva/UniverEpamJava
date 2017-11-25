package homework5.app.factories;

import homework5.app.entities.Passenger;
import homework5.app.entities.carriages.SecondClassSittingCar;
import homework5.app.exceptions.OutOfCarRangeException;

import java.util.ArrayList;
import java.util.Random;

public class SecondClassSittingCarFactory {

    public static SecondClassSittingCar create(ArrayList<Passenger> passengers){
        SecondClassSittingCar secondClassSittingCar = null;
        try{
            secondClassSittingCar = new SecondClassSittingCar(passengers);
        }catch (OutOfCarRangeException e){
            System.out.print(e.getMessage());
        }
        return secondClassSittingCar;
    }

    public static SecondClassSittingCar createRandom() {
        Random r = new Random();
        SecondClassSittingCar secondClassSittingCar = new SecondClassSittingCar();
        int passAmount = r.nextInt(secondClassSittingCar.MAX_PASSENGER_AMOUNT + 1);

        for (int i = 0; i < passAmount; i++) {
            try {
                secondClassSittingCar.addPassenger(PassengerFactory.createRandom());
            } catch (OutOfCarRangeException e) {
                System.out.print(e.getMessage());
            }
        }
        return secondClassSittingCar;
    }
}
