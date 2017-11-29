package factories;

import vehicles.CVehicle;

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
