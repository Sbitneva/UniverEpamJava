package sbitneva.homeworks;

import sbitneva.homeworks.entities.Bee;
import sbitneva.homeworks.entities.Forest;
import sbitneva.homeworks.entities.Task;

import java.util.ArrayList;
import java.util.Queue;

public class Main{
    public static Boolean found = false;
    private static ArrayList<Bee> beeQueue = new ArrayList<>();
    private static Queue<Task> taskQueue;

    public static void main(String...args) {
        final int beesNumber = 10;
        Forest forest = new Forest("src/main/resources/forest_map.txt");

        taskQueue = forest.getTasks();

        for(int i = 0; i < beesNumber; i++){
            beeQueue.add(new Bee(i, taskQueue));
            beeQueue.get(i).start();
        }

        for (int i = 0; i < beesNumber; i++) {
            try {
                beeQueue.get(i).join();
            } catch (InterruptedException e) {

            }
        }

        System.out.println("The end of searching! " + beeQueue.size());
    }
}