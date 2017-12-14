package sbitneva.homeworks.entities;

import java.util.LinkedList;
import java.util.Queue;

public class Tournament{
    public static int tour_id = 0;
   // public static Queue<Monk> winners = new LinkedList<>();

    public static  Queue<Monk> startTour(Queue<Monk> monks){
        Queue<Monk> winners = new LinkedList<>();
        //winners.clear();
        tour_id++;
        System.out.println("Tour # " + tour_id + "starts");
        System.out.println(monks.size());
        while(monks.size() > 0){
            try{
                Monk monk1 = monks.poll();
                Monk monk2 = monks.poll();
                System.out.println(monk1.getName() + " : " + monk2.getName());
                new Tour(monk1, monk2, winners).join();
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
            System.out.println(monks.size());
        }
        System.out.println("winner size = " + winners.size());
        return winners;
    }

    public Tournament(){

    }
}
