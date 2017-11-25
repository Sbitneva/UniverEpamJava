package homework5.app;

import homework5.app.entities.carriages.FreightCar;
import homework5.app.entities.trains.FreightTrain;
import homework5.app.exceptions.OutOfFreightTrainCarsAmount;
import homework5.app.factories.FreightCarFactory;
import homework5.app.factories.FreightTrainFactory;
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
