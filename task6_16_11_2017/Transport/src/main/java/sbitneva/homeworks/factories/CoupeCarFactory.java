package factories;

import entities.Passenger;
import entities.carriages.CoupeCar;
import exceptions.OutOfCarRangeException;

import java.util.ArrayList;
import java.util.Random;

public class CoupeCarFactory {

    public static CoupeCar create(ArrayList<Passenger> passengers){
        CoupeCar coupeCar = null;
        try{
            coupeCar = new CoupeCar(passengers);
        }catch (OutOfCarRangeException e){
            System.out.print(e.getMessage());
        }
        return coupeCar;
    }

    public static CoupeCar createRandom() {
        Random r = new Random();
        CoupeCar coupeCar = new CoupeCar();
        int passAmount = r.nextInt(coupeCar.MAX_PASSENGER_AMOUNT + 1);

        for (int i = 0; i < passAmount; i++) {
            try {
                coupeCar.addPassenger(PassengerFactory.createRandom());
            } catch (OutOfCarRangeException e) {
                System.out.print(e.getMessage());
            }
        }
        return coupeCar;
    }
}
