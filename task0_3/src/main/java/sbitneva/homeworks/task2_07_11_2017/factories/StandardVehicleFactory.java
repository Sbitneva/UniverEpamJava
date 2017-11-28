package task2_07_11_2017.factories;

import task2_07_11_2017.vehicles.CVehicle;

public class StandardVehicleFactory {

    public StandardVehicleFactory(){
    }

    public static CVehicle create(int key){
        switch(key){
            case 0:
                return CCarConcreteFactory.create();
            case 1:
                return CPlaneConcreteFactory.create();
            case 2:
                return CShipConcreteFactory.create();
            default:
                 return null;
        }
    }
}
