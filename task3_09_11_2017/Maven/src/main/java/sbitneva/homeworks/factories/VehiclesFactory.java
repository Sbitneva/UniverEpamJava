package factories;

import vehicles.*;

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
