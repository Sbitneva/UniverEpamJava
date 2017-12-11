package sbitneva.homeworks.entities;

import org.apache.log4j.Logger;
import sbitneva.homeworks.Main;

import java.util.Queue;

public class Bee extends Thread{
    private static Logger log = Logger.getLogger(Bee.class.getName());
    private String name;
    Queue<Task> tasks;
    Task currentTask;
    Queue<Bee> beeQueue;

    public Bee(int id, Queue tasks, Queue beeQueue){
        this.name = "Bee #" + id;
        this.tasks = tasks;
        this.beeQueue = beeQueue;
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return name;
    }

    private void pauseBee(){
        try {
            synchronized (beeQueue) {
                beeQueue.add(this);
                synchronized (this) {
                    System.out.println(this.getName() + " is waiting");
                    this.wait();
                }
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void run() {
        while (!tasks.isEmpty() && !Main.found) {
            System.out.println(this.name + " is running");
            synchronized (tasks) {
                currentTask = tasks.poll();
                System.out.println("tasks amount " + tasks.size());
            }
            if(currentTask != null) {
                int taskData[][] = currentTask.getTaskData();
                for (int i = 0; i < currentTask.getRows(); i++) {
                    for (int j = 0; j < currentTask.getColumns(); j++) {
                        if (taskData[i][j] == 1) {
                            System.out.println("Bee" + this.getName() + " found Winnie Pooh");
                            System.out.println("Winnie is here!!! In " + currentTask.getRowIndexes().get(i) +
                                    " row " + "and " + i + " column");
                            Main.found = true;
                            return;
                        }
                    }
                }
                System.out.println(this.name + " did't found Winnie");
                try {
                    beeQueue.add(this);
                    synchronized (this) {
                        System.out.println(this.name + " is waiting");
                        this.wait();
                    }
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
                System.out.println(this.name + " is awaking");
            }
        }
    }
}
