package app;

import entities.carriages.FreightCar;
import entities.trains.FreightTrain;
import exceptions.OutOfFreightTrainCarsAmount;
import factories.FreightCarFactory;
import factories.FreightTrainFactory;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class TestFreightTrain {
    FreightTrain freightTrain;

    @Test
    public void testFreightTrainOutOfRange(){
        ArrayList<FreightCar> freightCars = new ArrayList<>();
        freightTrain = new FreightTrain();
        for(int i = 0; i <= freightTrain.getMAX_CARS_AMOUNT(); i++){
            freightCars.add(FreightCarFactory.create());
        }
        try{
            freightTrain = FreightTrainFactory.create(freightCars);
        }catch (OutOfFreightTrainCarsAmount e){
            assertTrue(freightTrain.getCarriages().size() == 0);
        }

        for(int i = 0; i <= freightTrain.getMAX_CARS_AMOUNT(); i++){
            try {
                freightTrain.addCarriage(FreightCarFactory.create());
            }catch(OutOfFreightTrainCarsAmount e){
                assertTrue(freightTrain.getCarriages().size() == freightTrain.getMAX_CARS_AMOUNT());
            }
        }
    }
}
