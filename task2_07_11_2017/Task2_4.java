package task2;

import task2.vehicles.CVehicle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import task2.interfaces.*;
import task2.utils.PrintVehicles;

/**
 * 4. добавить к данной иерархии машину-амфибию, и БетМобиль, создать 3 масива сгупированых
 * по Интерфейсам Flyable, MoveAble, SwimAble
 *
 *@author Sbitneva Maria
 */
public class Task2_4 {

    private CVehicle vehicles[];
    private CVehicle movable[];
    private CVehicle flyable[];
    private CVehicle swimable[];

    Task2_4(CVehicle vehicles[]){
        this.vehicles = vehicles;

        selectFlyable();
        selectMovable();
        selectSwimable();

        PrintVehicles.print(getMovable(), "Movable Vehicles: ");
        PrintVehicles.print(getSwimable(), "Swimable Vehicles: ");
        PrintVehicles.print(getFlyable(), "Flyable Vehicles");
    }

    private void selectFlyable(){
        List<CVehicle> fly = new ArrayList<>();

        for(int i = 0; i < vehicles.length; i++){
            if (vehicles[i] instanceof FlyAble){
                fly.add(vehicles[i]);
            }
        }
        this.flyable = new CVehicle[fly.size()];
        fly.toArray(this.flyable);
    }

    private void selectMovable(){
        List<CVehicle> move = new LinkedList<>();
        for(int i = 0; i < vehicles.length; i++){
            if (vehicles[i] instanceof MoveAble){
                move.add(vehicles[i]);
            }
        }
        this.movable = new CVehicle[move.size()];
        move.toArray(this.movable);
    }

    private void selectSwimable(){
        List<CVehicle> swim = new LinkedList<>();
        for(int i = 0; i < vehicles.length; i++){
            if (vehicles[i] instanceof SwimAble){
                swim.add(vehicles[i]);
            }
        }
        this.swimable = new CVehicle[swim.size()];
        swim.toArray(this.swimable);
    }

    public CVehicle[] getVehicles() {
        return vehicles;
    }

    public CVehicle[] getMovable() {
        return movable;
    }

    public CVehicle[] getFlyable() {
        return flyable;
    }

    public CVehicle[] getSwimable() {
        return swimable;
    }
}
