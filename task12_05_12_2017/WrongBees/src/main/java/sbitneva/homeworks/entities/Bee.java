package sbitneva.homeworks.entities;

import org.apache.log4j.Logger;
import sbitneva.homeworks.Main;

import java.util.Queue;

public class Bee extends Thread{
    private static Logger log = Logger.getLogger(Bee.class.getName());
    private String name;
    private Queue<Task> tasks;

    public Bee(int id, Queue tasks){
        this.name = "Bee #" + id;
        this.tasks = tasks;
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run() {
        // Make sure all worker bees were started
        try {
            sleep(2000);
        }
        catch (InterruptedException e) {
        }
        while (!tasks.isEmpty() && !Main.found) {
            Task currentTask;
            System.out.println(this.name + " is working");
            synchronized (tasks) {
                currentTask = tasks.poll();
            }
            if(currentTask != null) {
                int taskData[] = currentTask.getTaskData();
                for (int i = 0; i < currentTask.getTaskData().length; i++) {
                    if (taskData[i] == 1) {
                        System.out.println(this.name + " found Winnie Pooh");
                        System.out.println("Winnie is here!!! In " + currentTask.getTaskIndex() +
                                " row " + "and " + i + " column");
                        Main.found = true;
                        return;
                    }
                }
                System.out.println(this.name + " did't found Winnie");
            }
        }
        System.out.println(this.name + " stop working");
    }
}
