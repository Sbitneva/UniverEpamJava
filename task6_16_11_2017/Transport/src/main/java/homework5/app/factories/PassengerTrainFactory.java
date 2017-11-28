package factories;

import entities.carriages.FirstClassSittingCar;
import entities.carriages.PassengerCoach;
import entities.trains.PassengerTrain;
import exceptions.OutOfPassengersTrainRangeException;

import java.util.ArrayList;
import java.util.Random;

public class PassengerTrainFactory {

    public static PassengerTrain create(ArrayList<PassengerCoach> carriages){
        PassengerTrain passengerTrain = new PassengerTrain();
        try{
            passengerTrain = new PassengerTrain(carriages);
        }catch (OutOfPassengersTrainRangeException e){
            System.out.print(e.getMessage());
        }

        return  passengerTrain;
    }

    public static PassengerTrain createRandom() throws OutOfPassengersTrainRangeException{
        PassengerTrain passengerTrain = new PassengerTrain();
        Random r = new Random();
        int amount = r.nextInt(passengerTrain.MAX_CARRIAGES_AMOUNT) + 1;

        for(int i = 0; i < amount; i++){
            int carType = r.nextInt(5);
            switch (carType){
                case 0:
                    passengerTrain.addCarriage(VIPCarFactory.createRandom());
                    break;
                case 1:
                    passengerTrain.addCarriage(CoupeCarFactory.createRandom());
                    break;
                case 2:
                    passengerTrain.addCarriage(SVCarFactory.createRandom());
                    break;
                case 3:
                    passengerTrain.addCarriage(FirstClassSittingCarFactory.createRandom());
                    break;
                default:
                    passengerTrain.addCarriage(SecondClassSittingCarFactory.createRandom());
                    break;
            }
        }
        return  passengerTrain;
    }

}
