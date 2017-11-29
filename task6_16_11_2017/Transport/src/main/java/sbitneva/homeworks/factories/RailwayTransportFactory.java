package factories;

import entities.RailwayTransport;
import entities.trains.Train;
import exceptions.OutOfPassengersTrainRangeException;

import java.util.ArrayList;
import java.util.Random;

public class RailwayTransportFactory {

    public static RailwayTransport create(ArrayList<Train> trains){
        RailwayTransport railwayTransport = new RailwayTransport();
        railwayTransport.setTrains(trains);
        return railwayTransport;
    }
    public static RailwayTransport createRandom(){
        RailwayTransport railwayTransport = new RailwayTransport();
        Random r = new Random();
        int trainsAmount = r.nextInt(200) + 1;
        for(int i = 0; i < trainsAmount; i++){
            int k = r.nextInt(2);
            switch (k){
                case 0:
                    try {
                        railwayTransport.addTrain(PassengerTrainFactory.createRandom());
                    }catch (OutOfPassengersTrainRangeException e){
                        System.out.print(e.getMessage());
                    }
                    break;
                default:
                    railwayTransport.addTrain(FreightTrainFactory.createRandom());
                   break;
            }
        }
        return railwayTransport;
    }
}
