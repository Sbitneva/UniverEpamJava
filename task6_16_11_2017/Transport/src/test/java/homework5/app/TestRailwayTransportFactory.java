package homework5.app;

import homework5.app.entities.RailwayTransport;
import homework5.app.entities.carriages.FirstClassSittingCar;
import homework5.app.entities.trains.PassengerTrain;
import homework5.app.entities.trains.Train;
import homework5.app.exceptions.OutOfPassengersTrainRangeException;
import homework5.app.factories.FirstClassSittingCarFactory;
import homework5.app.factories.PassengerTrainFactory;
import homework5.app.factories.RailwayTransportFactory;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class TestRailwayTransportFactory {
    RailwayTransport railwayTransport;
    @Test
    public void testRailwayTransportRandomGeneration(){
        this.railwayTransport = RailwayTransportFactory.createRandom();
        for(int i = 0; i < railwayTransport.getTrains().size(); i++){
            assertTrue(railwayTransport.getTrains().get(i) != null);
        }
        ArrayList<Train> passengerTrains = new ArrayList<>();
        try{
            passengerTrains.add(PassengerTrainFactory.createRandom());
            this.railwayTransport = RailwayTransportFactory.create(passengerTrains);
            assertTrue(railwayTransport.getSize() == 1);
        }catch(OutOfPassengersTrainRangeException e){

        }


    }
}
