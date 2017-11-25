package homework5.app.entities.trains;

import homework5.app.entities.carriages.PassengerCoach;
import homework5.app.exceptions.OutOfPassengersTrainRangeException;

import java.util.ArrayList;
import java.util.Comparator;

public class PassengerTrain extends Train {
    private int id;
    private int passengers;
    private int baggage;
    public final int MAX_CARRIAGES_AMOUNT = 20;
    private ArrayList<PassengerCoach> carriages;

    public PassengerTrain() {
        super();
        this.id = getId();
        carriages = new ArrayList<>();
    }

    public PassengerTrain(ArrayList<PassengerCoach> carriages) throws OutOfPassengersTrainRangeException {
        super();
        this.id = getId();
        if (carriages.size() > this.MAX_CARRIAGES_AMOUNT) {
            throw new OutOfPassengersTrainRangeException("Too big amount of carriges for Passenger Train");
        } else {
            this.carriages = carriages;
        }
    }

    public int getPassengersAmount() {
        this.passengers = 0;
        for(int i = 0; i < this.carriages.size(); i++){
            this.passengers += carriages.get(i).getPassengerAmount();
        }
        return passengers;
    }

    public int getBaggageAmount() {
        this.baggage = 0;
        for(int i = 0; i < this.carriages.size(); i++){
            this.baggage += carriages.get(i).getBaggageAmount();
        }
        return baggage;
    }

    public ArrayList<PassengerCoach> getCarriages() {
        return carriages;
    }

    public void addCarriage(PassengerCoach passengerCoach) throws OutOfPassengersTrainRangeException {
        if (this.carriages.size() >= this.MAX_CARRIAGES_AMOUNT) {
            throw new OutOfPassengersTrainRangeException("Passenger train is full and there is no ability to addCarriages cars");
        }
        this.carriages.add(passengerCoach);
        refreshPassengersAmount();
        refreshBaggageAmount();
    }

    @Override
    public String toString() {
        return "\n PassengerTrain{" +
                "id=" + id +
                ", passengers=" + passengers +
                ", baggage=" + baggage +
                ", carriages=" + carriages +
                '}';
    }

    private void refreshPassengersAmount() {
        this.passengers = 0;
        for (int i = 0; i < carriages.size(); i++) {
            this.passengers += (carriages.get(i)).getPassengerAmount();
        }
    }

    private void refreshBaggageAmount() {
        this.baggage = 0;
        for (int i = 0; i < carriages.size(); i++) {
            this.baggage += carriages.get(i).getBaggageAmount();
        }
    }

    public void sortCarriagesByComfort() {
        carriages.sort(Comparator.comparingInt(PassengerCoach::getComfortLevel));
    }

    public ArrayList<PassengerCoach> getCarriagesByPassengersInRange(int startRange, int endRange) {
        ArrayList<PassengerCoach> carriagesInRange = new ArrayList<PassengerCoach>();
        for (int i = 0; i < this.carriages.size(); i++) {
            int n = carriages.get(i).getPassengers().size();
            if ((n >= startRange) && (n <= endRange)) {
                carriagesInRange.add(carriages.get(i));
            }
        }
        return carriagesInRange;
    }

}
