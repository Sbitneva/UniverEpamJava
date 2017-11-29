package hw2;

import hw2.vehicles.CPlane;
import hw2.vehicles.CVehicle;

import java.util.LinkedList;
import java.util.List;

/**
 * 3. найти механизмы со скоростью в диапазоне 200 - 500, но не Plane
 *
 * @author Sbitneva Maria
 */
public class Task2_3 {
    private CVehicle vehicles[];

    public Task2_3(CVehicle vehicles[]){
        this.vehicles = vehicles;
        List<CVehicle> notPlanes = selectSpeedInRangeNotPlane();

        System.out.println("\nVehicles with speed in [200..500] range which are not planes\n");

        for(CVehicle vehicle:notPlanes){
            System.out.println(vehicle.getClass().getSimpleName() + " with speed " + vehicle.getSpeed());
        }
    }

    /**
     * Finds vehicles with speed in [200..500] range which are not planes
     *
     * @return array with vehicles
     */
    private List<CVehicle> selectSpeedInRangeNotPlane(){
        List res = new LinkedList<CVehicle>();

        int max = 0;
        for (int i = 0; i < vehicles.length; i++){
            if(!(vehicles[i] instanceof CPlane) && (vehicles[i].getSpeed() >= 200) && (vehicles[i].getSpeed() <= 500)){
               res.add(vehicles[i]);
            }
        }
        return res;
    }
}
