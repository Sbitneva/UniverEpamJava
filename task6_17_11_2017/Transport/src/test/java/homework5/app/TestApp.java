package homework5.app;

import homework5.app.app.App;
import homework5.app.entities.RailwayTransport;
import homework5.app.entities.trains.PassengerTrain;
import homework5.app.entities.trains.Train;
import homework5.app.exceptions.OutOfPassengersTrainRangeException;
import homework5.app.factories.PassengerTrainFactory;
import homework5.app.factories.RailwayTransportFactory;
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
