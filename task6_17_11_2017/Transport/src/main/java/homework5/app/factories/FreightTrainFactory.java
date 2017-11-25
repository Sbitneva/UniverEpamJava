package homework5.app.factories;

import homework5.app.entities.carriages.FreightCar;
import homework5.app.entities.trains.FreightTrain;
import homework5.app.exceptions.OutOfFreightTrainCarsAmount;

import java.util.ArrayList;
import java.util.Random;

public class FreightTrainFactory {
    public static FreightTrain create(ArrayList<FreightCar> cars) throws OutOfFreightTrainCarsAmount{
        FreightTrain freightTrain = null;
        freightTrain = new FreightTrain(cars);
        return freightTrain;
    }

    public static FreightTrain createRandom(){
        FreightTrain freightTrain = new FreightTrain();
        ArrayList<FreightCar> cars = new ArrayList<>();
        Random r = new Random();
        int size = r.nextInt(freightTrain.getMAX_CARS_AMOUNT());
        for(int i = 0; i < size; i++){
            cars.add(FreightCarFactory.create());
        }
        try {
            freightTrain = new FreightTrain(cars);
        }catch(OutOfFreightTrainCarsAmount e){
            System.out.print(e.getMessage());
        }
        return freightTrain;
    }
}
