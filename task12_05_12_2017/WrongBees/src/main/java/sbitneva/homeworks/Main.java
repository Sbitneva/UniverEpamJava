package sbitneva.homeworks;

import org.apache.log4j.Logger;
import sbitneva.homeworks.entities.Bee;
import sbitneva.homeworks.entities.Forest;
import sbitneva.homeworks.entities.TaskQueue;

import java.util.ArrayList;

public class Main {
    public static Boolean found = false;
    public static ArrayList<Bee> beeQueue = new ArrayList<>();
    public static int row = 0;
    public static int column = 0;
    private static Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String... args) {
        final int BEES_NUMBER = 10;
        final String FOREST_FILE_PATH = "src/main/resources/forest_map.txt";

        Forest forest = new Forest(FOREST_FILE_PATH);
        TaskQueue taskQueue = forest.getTasks();

        for (int i = 0; i < BEES_NUMBER; i++) {
            beeQueue.add(new Bee(i, taskQueue));
            beeQueue.get(i).start();
        }

        for (int i = 0; i < BEES_NUMBER; i++) {
            try {
                beeQueue.get(i).join();
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
        }
    }
}