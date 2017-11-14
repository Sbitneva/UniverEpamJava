package task2_07_11_2017.factories;

import task2_07_11_2017.vehicles.*;

public class VehiclesFactory {

    public static CVehicle create(int key){
        switch(key){
            case 0:
                return CCarConcreteFactory.create();
            case 1:
                return CPlaneConcreteFactory.create();
            case 2:
                return CShipConcreteFactory.create();
            case 3:
                return CAmphibianCarConcreteFactory.create();
            case 4:
                return CBatMobileConcreteFactory.create();
            default:
                return null;
        }
    }
}
