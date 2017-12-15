package sbitneva.homeworks.airport;

import sbitneva.homeworks.planes.Plane;
import sbitneva.homeworks.planes.RandomPlanesFactory;

import java.util.Queue;

public class Trap extends Thread{
    public boolean ready = false;
    public boolean end = false;
    public Queue<Plane> planes;

    public QPlane qPlane = new QPlane();
    public Trap(){
        planes = RandomPlanesFactory.create();
        System.out.println("Airport has " + planes.size() + " planes");

        start();
    }

    @Override
    public void run(){
        System.out.println("Trap running");

        while(!end){
            try{
                sleep(500);

            }catch(InterruptedException e){
                System.out.println(e.getMessage());
            }
            if(!ready){
                if(planes.size() > 0) {
                    Plane p = planes.poll();

                    System.out.println(p.toString());
                    qPlane.putPlane(p);
                    ready = true;
                    System.out.println("Trap ready");
                }else{

                }
            }
        }
    }
}
