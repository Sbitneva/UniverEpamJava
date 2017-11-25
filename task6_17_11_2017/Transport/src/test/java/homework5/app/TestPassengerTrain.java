package homework5.app;

import homework5.app.entities.Passenger;
import homework5.app.entities.carriages.PassengerCoach;
import homework5.app.entities.trains.PassengerTrain;
import homework5.app.exceptions.OutOfCarRangeException;
import homework5.app.exceptions.OutOfPassengersTrainRangeException;
import homework5.app.factories.*;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;


public class TestPassengerTrain {

    private PassengerTrain passengerTrain = new PassengerTrain();
    private ArrayList<PassengerCoach> passengerCoaches = new ArrayList<>();

    @Test
    public void testTrainAddOutOfRange(){
         int outOfRange = passengerTrain.MAX_CARRIAGES_AMOUNT + 1;
         for(int i = 0; i < outOfRange; i++){
             try {
                 passengerTrain.addCarriage(VIPCarFactory.createRandom());
             }catch(OutOfPassengersTrainRangeException e){
                 System.out.print(e.getMessage());
                 assertTrue("Out of train cars amount problem",
                         i == passengerTrain.MAX_CARRIAGES_AMOUNT);
             }
         }
        assertTrue("Out of train cars amount problem",
                passengerTrain.getCarriages().size() == passengerTrain.MAX_CARRIAGES_AMOUNT);
    }

    @Test
    public void testTrainConstructorOutOfRange(){
        int outOfRange = passengerTrain.MAX_CARRIAGES_AMOUNT + 1;
        ArrayList<PassengerCoach> passengerCoaches = new ArrayList<>();

        for(int i = 0; i < outOfRange; i++){
            passengerCoaches.add(VIPCarFactory.createRandom());
        }
        assertTrue("Out of train cars amount problem",
                passengerTrain.getCarriages().size() == 0);
    }

    @Test
    public void testPassengerTrainByComfort(){
        ArrayList<PassengerCoach> passengerCoaches = new ArrayList<>();
        passengerCoaches.add(SecondClassSittingCarFactory.createRandom());
        passengerCoaches.add(FirstClassSittingCarFactory.createRandom());
        passengerCoaches.add(SVCarFactory.createRandom());
        passengerCoaches.add(VIPCarFactory.createRandom());
        passengerCoaches.add(CoupeCarFactory.createRandom());

        this.passengerTrain = PassengerTrainFactory.create(passengerCoaches);

        passengerTrain.sortCarriagesByComfort();

        for(int i = 0; i < passengerCoaches.size(); i++){
            assertTrue("Sorting error",
                    passengerTrain.getCarriages().get(i).getComfortLevel() == i + 1);
        }

    }
    @Test
    public void testPassengerTrainBaggageAmount(){
        try {
            passengerTrain = PassengerTrainFactory.createRandom();
        }catch(OutOfPassengersTrainRangeException e){
            assertTrue(false);
        }
        int baggageAmount = 0;
        for(int i = 0; i < passengerTrain.getCarriages().size(); i++){
            baggageAmount += passengerTrain.getCarriages().get(i).getBaggageAmount();
        }
        assertTrue(baggageAmount == passengerTrain.getBaggageAmount());
        try{
            PassengerCoach passengerCoach = SecondClassSittingCarFactory.createRandom();
            passengerTrain.addCarriage(passengerCoach);
            baggageAmount += passengerCoach.getBaggageAmount();
            assertTrue(baggageAmount == passengerTrain.getBaggageAmount());
        }catch (OutOfPassengersTrainRangeException e){

        }


    }
}
