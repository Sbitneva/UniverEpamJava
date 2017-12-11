package sbitneva.homeworks;

import sbitneva.homeworks.entities.Bee;
import sbitneva.homeworks.entities.Forest;
import sbitneva.homeworks.entities.Task;

import java.util.LinkedList;
import java.util.Queue;

public class Main{
    public static Boolean found = false;
    public static Queue<Bee> beeQueue = new LinkedList<>();
    public static Queue<Task> taskQueue;

    public static void main(String...args) {
        final int tasksNumber = 23;
        final int beesNumber = 10;
        Forest forest = new Forest("src/main/resources/forest_map.txt", tasksNumber);

        taskQueue = forest.getTasks();

        int i = 0;
        while(i < beesNumber){
            beeQueue.add(new Bee(i, taskQueue, beeQueue));
            i++;
        }

        i = 0;
        while (i < beesNumber){
            Bee bee = beeQueue.poll();
            bee.start();
            i++;
        }

        while(!Main.found) {
            synchronized (beeQueue) {
                while(!beeQueue.isEmpty()) {
                    if (Main.found) {
                        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                        break;
                    } else {
                        Bee bee = beeQueue.poll();
                        synchronized (bee) {
                            bee.notify();
                        }
                    }
                }
            }
        }
        System.out.println("The end of searching! " + beeQueue.size());
    }
}