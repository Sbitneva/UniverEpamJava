package sbitneva.homeworks.entities;

import org.apache.log4j.Logger;
import sbitneva.homeworks.Main;
import sbitneva.homeworks.queue.MonkQueue;

public class Tournament extends Thread {
    private static Logger   log = Logger.getLogger(Main.class.getName());
    private static int      tour_id;
    private MonkQueue       winners;
    private MonkQueue       monks;

    public Tournament(MonkQueue monks) {
        this.monks = monks;
        this.winners = new MonkQueue();
        start();
    }

    public void run() {
        tour_id++;
        log.debug("Tour # " + tour_id + " starts");

        while (monks.size() > 1) {
            try {
                sleep(200);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }

            try {
                Monk monk1 = monks.poll();
                Monk monk2 = monks.poll();
                log.debug(monk1.getName() + " : " + monk2.getName());
                new Tour(monk1, monk2, winners).join();
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
        }
    }

    public MonkQueue getWinners() {
        return winners;
    }
}
