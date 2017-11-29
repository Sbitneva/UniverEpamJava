package factories;

import entities.Passenger;
import entities.carriages.VIPCar;
import exceptions.OutOfCarRangeException;

import java.util.ArrayList;
import java.util.Random;

public class VIPCarFactory {

    public static VIPCar create(ArrayList<Passenger> passengers){
        VIPCar vipCar = null;
        try{
            vipCar = new VIPCar(passengers);
        }catch (OutOfCarRangeException e){
            System.out.print(e.getMessage());
        }
        return vipCar;
    }

    public static VIPCar createRandom(){
        Random r = new Random();
        VIPCar vipCar = new VIPCar();
        int passAmount = r.nextInt(vipCar.MAX_PASSENGER_AMOUNT) + 1;

        for(int i = 0; i < passAmount; i++){
            try{
                vipCar.addPassenger(PassengerFactory.createRandom());
            }catch(OutOfCarRangeException e){
                System.out.print(e.getMessage());
            }
        }

        return vipCar;
    }
}
