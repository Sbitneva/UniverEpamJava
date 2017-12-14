package sbitneva.homeworks.entities;

import java.util.LinkedList;
import java.util.Queue;

public class Tour extends Thread {

    private Monk monk1;
    private Monk monk2;
    private Queue<Monk> winners = new LinkedList<>();

    public Tour(Monk monk1, Monk monk2, Queue<Monk> winners){
        this.monk1 = monk1;
        this.monk2 = monk2;
        this.winners = winners;

        try {
            sleep(500);
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }
        start();
    }

    @Override
    public void run(){
        synchronized(winners) {
            if (monk1.getEnergy() > monk2.getEnergy()) {
                winners.add(monk1);
            } else {
                winners.add(monk2);
            }
        }
    }
}
