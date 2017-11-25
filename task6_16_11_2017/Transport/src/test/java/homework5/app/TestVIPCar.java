package homework5.app;
import homework5.app.entities.carriages.VIPCar;
import homework5.app.exceptions.OutOfCarRangeException;
import homework5.app.factories.PassengerFactory;
import org.junit.Test;


import static org.junit.Assert.assertTrue;

public class TestVIPCar {
    VIPCar vipCar = new VIPCar();

    @Test
    public void testOutOfCarRange(){

        int outOfrange = this.vipCar.MAX_PASSENGER_AMOUNT + 1;
        for(int i = 0; i < outOfrange; i++){
            try {
                vipCar.addPassenger(PassengerFactory.createRandom());
            }catch(OutOfCarRangeException e){
                assertTrue(i == vipCar.MAX_PASSENGER_AMOUNT);
                break;
            }
        }
        assertTrue(vipCar.getPassengerAmount() == vipCar.MAX_PASSENGER_AMOUNT);
    }

}
