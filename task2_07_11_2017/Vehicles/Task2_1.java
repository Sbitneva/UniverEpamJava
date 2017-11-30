package hw2;

import hw2.vehicles.CVehicle;

import java.util.LinkedList;

/**
 * 1. механизмы с наименьшей ценой с наибольшей скоростью и не старше 5 лет
 *
 * @author Sbitneva Maria
 */
public class Task2_1 {
    private CVehicle vehicles[];

    public Task2_1(CVehicle vehicles[]){
        this.vehicles = vehicles;
        CVehicle vehicle = findMinPrice();

        System.out.println("\nVehicle with min price: \n");
        System.out.println(vehicle.getClass().getSimpleName() + " with price " + vehicle.getPrice());

        vehicle = findMaxSpeed();
        System.out.println("\nVehicle with max speed: \n");
        System.out.println(vehicle.getClass().getSimpleName() + " with speed " + vehicle.getSpeed());

        LinkedList <CVehicle> vehicleList = selectNotOlder5();
        System.out.println("\nvehicles not older then 5 years: \n");
        for (int i = 0; i < vehicleList.size(); i++){
            System.out.println(vehicleList.get(i).getClass().getSimpleName() + "\t age = " + (2017 - vehicleList.get(i).getYearIssue()));
        }
    }

    /**
     * Finds vehicle with lowest price
     */
    private CVehicle findMinPrice(){
        int min = Integer.MAX_VALUE;
        CVehicle lowPriceVehicle = new CVehicle();

        for (int i = 0; i < vehicles.length; i++){
            if(vehicles[i].getPrice() < min){
                min = vehicles[i].getPrice();
                lowPriceVehicle = vehicles[i];
            }
        }

        return lowPriceVehicle;
    }

    /**
     * Finds vehicle with max speed
     */
    private CVehicle findMaxSpeed(){
        int max = 0;

        CVehicle vehicle = new CVehicle();

        for (int i = 0; i < vehicles.length; i++){
            if(vehicles[i].getSpeed() > max){
                max = vehicles[i].getSpeed();
                vehicle = vehicles[i];
            }
        }
        return vehicle;
    }

    /**
     * Finds vehicles not older then 5 years
     */
    private LinkedList<CVehicle> selectNotOlder5(){
        LinkedList res = new LinkedList<CVehicle>();

        for(int i = 0; i < vehicles.length; i++){
            if((2017 - vehicles[i].getYearIssue()) <= 5){
               res.add(vehicles[i]);
            }
        }
        return res;
    }

}
