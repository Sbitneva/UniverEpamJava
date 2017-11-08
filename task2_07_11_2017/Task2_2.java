package task2;

import task2.vehicles.CPlane;
import task2.vehicles.CVehicle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * 2. найти из механизмов Plane c с высотой полета выше 5000 с годом выпуска после 2000
 *
 * @author Sbitneva Maria
 */
public class Task2_2 {
    private CVehicle vehicles[];

    public Task2_2(CVehicle vehicles[]){
        this.vehicles = vehicles;

        List<CPlane> planes = selectByHeightAndYear();

        for (CPlane plane:planes){
            System.out.println( plane.getClass().getSimpleName() + " with flight altitude " +
                    + plane.getFlightAltitude() + "\t and year of issue " +
                    + plane.getYearIssue());
        }
    }

    /**
     * Finds Planes with height altitude more than 5000 and year of issue after 2000
     *
     */
    private List<CPlane> selectByHeightAndYear(){
        List<CPlane> planes = new LinkedList<>();

        System.out.println(" \nPlanes with height altitude more than 5000 and year of issue after 2000\n");
        int res = 0;
        for(int i = 0; i < vehicles.length; i++){
            if( (vehicles[i].getYearIssue() > 2000) && (vehicles[i] instanceof CPlane)){
                CPlane plane = (CPlane)vehicles[i];
                if(plane.getFlightAltitude() > 5000){
                    planes.add(plane);
                }

            }
        }
        return planes;
    }
}
