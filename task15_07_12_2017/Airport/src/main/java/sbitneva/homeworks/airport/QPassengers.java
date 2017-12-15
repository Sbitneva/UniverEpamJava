package sbitneva.homeworks.airport;

import org.apache.log4j.Logger;
import sbitneva.homeworks.passengers.Passenger;

import java.util.LinkedList;
import java.util.Queue;

public class QPassengers {
    static Logger log = Logger.getLogger(QPassengers.class.getName());

    Queue<Passenger> passengers = new LinkedList<>();
    boolean free = true;

    synchronized public void putPassengers(Queue<Passenger> passengers){
        while(!free){
            try {
                wait();
            }catch (InterruptedException e){
                log.error(e.getMessage());
            }
        }
        System.out.println("Put passengers");
        this.passengers = passengers;
        this.free = false;
    }

    synchronized public Queue<Passenger> getPassengers(){
        while(free){
            try {
                wait();
            }catch (InterruptedException e){
                log.error(e.getMessage());
            }
        }
        System.out.println("Get passengers");
        this.free = true;
        return passengers;
    }
}
