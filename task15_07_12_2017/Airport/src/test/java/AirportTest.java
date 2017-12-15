import org.junit.Test;
import sbitneva.homeworks.airport.Terminal;
import sbitneva.homeworks.airport.Trap;
import sbitneva.homeworks.passengers.Passenger;
import sbitneva.homeworks.planes.Plane;

import java.util.Queue;

import static org.junit.Assert.assertTrue;

public class AirportTest {
    @Test
    public void resultTest(){
        Trap trap = new Trap();
        Terminal terminal = new Terminal();
        int processedPlanesAmount = 0;
        int expectedProcessedPlanesAmount = trap.planes.size();

        while(true) {
            try{
                Thread.sleep(500);
            }catch(InterruptedException e) {
            }
            if (trap.ready && terminal.ready) {
                Queue<Passenger> passengers = terminal.qTerminal.getPassengers();
                Plane plane = trap.qPlane.getPlane();
                plane.setPassenggers(passengers);
                processedPlanesAmount++;
                System.out.println("Passengers in " + plane.toString() + " and ready for fly");
                System.out.println(plane.toString() + " fly away");
                if(trap.planes.size() == 0){
                    System.out.println("The END of an Airport work ");
                    assertTrue(processedPlanesAmount == expectedProcessedPlanesAmount);
                    assertTrue(trap.planes.size() == 0);
                    trap.end = true;
                    terminal.end = true;
                    return;
                }else {
                    terminal.ready = false;
                    trap.ready = false;
                }
            }
        }


    }
}
