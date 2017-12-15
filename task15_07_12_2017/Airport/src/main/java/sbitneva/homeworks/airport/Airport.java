package sbitneva.homeworks.airport;

import org.apache.log4j.Logger;
import sbitneva.homeworks.passengers.Passenger;
import sbitneva.homeworks.planes.Plane;

import java.util.Queue;

public class Airport {
    static Logger log = Logger.getLogger(Airport.class.getName());

    public static void main(String args[]){
        Trap trap = new Trap();
        Terminal terminal = new Terminal();
        while(true) {
            try{
                Thread.sleep(500);
            }catch(InterruptedException e) {
                log.error(e.getMessage());
            }
            if (trap.ready && terminal.ready) {
                Queue<Passenger> passengers = terminal.qTerminal.getPassengers();
                Plane plane = trap.qPlane.getPlane();
                plane.setPassenggers(passengers);
                System.out.println("Passengers in " + plane.toString() + " and ready for fly");
                System.out.println(plane.toString() + " fly away");
                if(trap.planes.size() == 0){
                    System.out.println("The END of an Airport work ");
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
