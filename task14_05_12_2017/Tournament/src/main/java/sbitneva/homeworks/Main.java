package sbitneva.homeworks;

import sbitneva.homeworks.entities.Monk;
import sbitneva.homeworks.entities.Tournament;
import sbitneva.homeworks.factories.MonkFactory;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    /*
    public static Queue<Monk> monks = new LinkedList<>();
    public static Queue<Monk> winners = new LinkedList<>();

    public static void main(String args[]){
        for(int i = 0; i < 32; i++){
            monks.add(MonkFactory.create());
        }

        while(winners.size() != 1){
            winners = Tournament.startTour(monks);
            monks = winners;
            System.out.println(winners.size());
            System.out.println(monks.size());
        }

        System.out.println("Winner of the Tournament is..." + winners.peek().toString());
    }
    */
}
