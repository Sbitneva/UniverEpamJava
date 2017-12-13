package sbitneva.homeworks.entities;

import sbitneva.homeworks.Main;

public class Loader extends Thread {
    SmallQ middleQ;

    public Loader(){
        middleQ = new SmallQ();
        try{
            sleep(2000);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        start();
    }

    @Override
    public void run(){
        while(!Main.end_calc){
            try{
                sleep(10);
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println("END of LOADER");
    }
}
