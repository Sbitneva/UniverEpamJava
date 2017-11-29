package entities;

import entities.trains.Train;

import java.util.ArrayList;

public class RailwayTransport {
    ArrayList<Train> trains;

    public RailwayTransport(){
        trains = new ArrayList<>();
    }

    public RailwayTransport(ArrayList<Train> trains){
        this.trains = trains;
    }

    public ArrayList<Train> getTrains() {
        return trains;
    }

    public void setTrains(ArrayList<Train> trains) {
        this.trains = trains;
    }

    @Override
    public String toString() {
        return "RailwayTransport{" +
                "trains=" + trains +
                '}';
    }

    public void addTrain(Train train){
        this.trains.add(train);
    }

    public int getSize(){
        return trains.size();
    }
}
