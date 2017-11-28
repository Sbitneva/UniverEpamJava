package task2_07_11_2017.utils;

import task2_07_11_2017.vehicles.CVehicle;

public class PrintVehicles {
    static public void print(CVehicle arr[], String mes){
        System.out.println("\n" +  mes + "\n");
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i].getClass().getSimpleName() + "\t year " + arr[i].getYearIssue() + "\t speed " +
                                arr[i].getSpeed());
        }
    }
}
