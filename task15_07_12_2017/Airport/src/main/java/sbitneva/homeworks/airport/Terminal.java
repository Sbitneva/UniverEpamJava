package sbitneva.homeworks.airport;

import sbitneva.homeworks.passengers.RandomPassengersFactory;

public class Terminal extends Thread{
    public  boolean ready = false;
    public boolean end = false;
    public QPassengers qTerminal = new QPassengers();

    public Terminal(){
        start();
    }

    @Override
    public void run(){
        System.out.println("Terminal running");
        while(!end){
            try{
                sleep(500);
            }catch(InterruptedException e){
                System.out.println(e.getMessage());
            }
            if(!ready){
                qTerminal.putPassengers(RandomPassengersFactory.create());
                ready = true;
                System.out.println("Terminal ready");
            }else{
            }
        }
    }

}
