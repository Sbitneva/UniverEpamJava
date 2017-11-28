package app;

import entities.RailwayTransport;
import entities.carriages.FirstClassSittingCar;
import entities.trains.PassengerTrain;
import entities.trains.Train;
import exceptions.OutOfPassengersTrainRangeException;
import factories.FirstClassSittingCarFactory;
import factories.PassengerTrainFactory;
import factories.RailwayTransportFactory;
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
