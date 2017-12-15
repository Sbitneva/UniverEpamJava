package sbitneva.homeworks.airport;

import org.apache.log4j.Logger;
import sbitneva.homeworks.planes.Plane;

public class QPlane {
    static Logger log = Logger.getLogger(QPlane.class.getName());
    boolean free = true;
    Plane plane;

    synchronized public void putPlane(Plane plane){
        while(!free){
            try {
                wait();
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Put plane " + plane.toString());
        this.plane = plane;
        this.free = false;
    }

    synchronized public Plane getPlane(){
        while(free){
            try {
                wait();
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println("get plane " + plane.toString());
        this.free = true;
        return plane;
    }
}
