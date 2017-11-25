package homework5.app.utils;

import homework5.app.entities.carriages.PassengerCoach;
import homework5.app.entities.trains.PassengerTrain;

import java.util.ArrayList;

public class Utils {
    public static void printCarriagesByLevels(PassengerTrain passengerTrain){
        for(int i = 0; i < passengerTrain.getCarriages().size(); i++){
            System.out.println(passengerTrain.getCarriages().get(i).getClass().getSimpleName() + "\t\t\t\t\t\t" +
                    passengerTrain.getCarriages().get(i).getComfortLevel() );
        }
    }

    public static void printCarriagesByPassengers(PassengerTrain passengerTrain){
        for(int i = 0; i < passengerTrain.getCarriages().size(); i++){
            System.out.println(passengerTrain.getCarriages().get(i).getClass().getSimpleName() + "\t\t\t\t\t\t" +
                    passengerTrain.getCarriages().get(i).getPassengerAmount());
        }
    }

    public static void printCarriagesByPassengers(ArrayList<PassengerCoach> passengerCoaches){
        for(int i = 0; i < passengerCoaches.size(); i++){
            System.out.println(passengerCoaches.get(i).getClass().getSimpleName() + "\t\t\t" +
                    passengerCoaches.get(i).getPassengers().size());
        }
    }
}
