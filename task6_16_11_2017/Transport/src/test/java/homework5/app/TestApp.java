package app;

import app.App;
import entities.RailwayTransport;
import entities.trains.PassengerTrain;
import entities.trains.Train;
import exceptions.OutOfPassengersTrainRangeException;
import factories.PassengerTrainFactory;
import factories.RailwayTransportFactory;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class TestApp {
    @Test
    public void testextractPassengerTrains(){

        ArrayList<Train> trains = new ArrayList<>();
        try{
            trains.add((Train)PassengerTrainFactory.createRandom());
            trains.add((Train)PassengerTrainFactory.createRandom());
            trains.add((Train)PassengerTrainFactory.createRandom());
            RailwayTransport railwayTransport =  RailwayTransportFactory.create(trains);
            ArrayList<PassengerTrain> pt = App.extractPassengerTrains(railwayTransport);
            assertTrue(pt.size() == 3);

        }catch(OutOfPassengersTrainRangeException e){
            assertTrue(false);
        }
        RailwayTransport railwayTransport =  new RailwayTransport(trains);
        ArrayList<PassengerTrain> pt = App.extractPassengerTrains(railwayTransport);
        assertTrue(pt.size() == 3);

    }
}
