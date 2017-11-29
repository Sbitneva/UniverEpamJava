package entities.trains;

import entities.carriages.FreightCar;
import exceptions.OutOfFreightTrainCarsAmount;

import java.util.ArrayList;

public class FreightTrain extends Train {
    private ArrayList<FreightCar> carriages;
    private int currentId;
    private int MAX_CARS_AMOUNT = 20;

    public FreightTrain(){
        super();
        this.carriages = new ArrayList<>();
        this.currentId = getId();
    }

    public FreightTrain(ArrayList<FreightCar> carriges) throws OutOfFreightTrainCarsAmount{
        if(carriges.size() > MAX_CARS_AMOUNT){
            throw new OutOfFreightTrainCarsAmount();
        }else{
            this.carriages = carriges;
        }
        this.currentId = getId();
    }

    public int getId(){
        return this.currentId;
    }

    public int getMAX_CARS_AMOUNT() {
        return MAX_CARS_AMOUNT;
    }

    public void addCarriage(FreightCar freightCar)throws OutOfFreightTrainCarsAmount{
        if(this.carriages.size() == this.getMAX_CARS_AMOUNT()){
            throw new OutOfFreightTrainCarsAmount();
        }else{
            carriages.add(freightCar);
        }
    }

    public ArrayList<FreightCar> getCarriages() {
        return carriages;
    }

    public void setCarriages(ArrayList<FreightCar> carriages) throws OutOfFreightTrainCarsAmount{
        if(carriages.size() > MAX_CARS_AMOUNT){
            throw new OutOfFreightTrainCarsAmount();
        }else{
            this.carriages = carriages;
        }
    }
}
