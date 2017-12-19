package sbitneva.homeworks.entities;

import org.apache.log4j.Logger;
import sbitneva.homeworks.Main;

public class Bee extends Thread {
    private static Logger log = Logger.getLogger(Bee.class.getName());
    private String name;
    private TaskQueue tasks;

    public Bee(int id, TaskQueue tasks) {
        this.name = "Bee #" + id;
        this.tasks = tasks;
        log.debug(this.toString());
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run() {
        /* Make sure all worker bees were started*/
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        while (!tasks.isEmpty() && !Main.found) {
            Task currentTask = tasks.poll();

            log.debug(this.name + " is working");

            if (currentTask != null) {
                int taskData[] = currentTask.getTaskData();
                for (int i = 0; i < currentTask.getTaskData().length; i++) {
                    if (taskData[i] == 1) {
                        log.debug(this.name + " found Winnie Pooh");
                        log.debug("Winnie is here!!! In " + currentTask.getTaskIndex() +
                                " row " + "and " + i + " column");
                        Main.row = currentTask.getTaskIndex();
                        Main.column = i;
                        Main.found = true;
                        return;
                    }
                }
                log.debug(this.name + " did't found Winnie");
            }
        }
        log.debug(this.name + " stop working");
    }
}
