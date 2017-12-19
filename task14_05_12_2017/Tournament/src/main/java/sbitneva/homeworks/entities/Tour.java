package sbitneva.homeworks.entities;

import org.apache.log4j.Logger;
import sbitneva.homeworks.Main;
import sbitneva.homeworks.queue.MonkQueue;

public class Tour extends Thread {
    private static Logger   log = Logger.getLogger(Main.class.getName());
    private Monk            monk1;
    private Monk            monk2;
    private MonkQueue       winners;

    public Tour() {
        this.monk1 = new Monk();
        this.monk2 = new Monk();
        winners = new MonkQueue();
    }

    public Tour(Monk monk1, Monk monk2, MonkQueue winners) {
        this.monk1 = monk1;
        this.monk2 = monk2;
        this.winners = winners;

        try {
            sleep(500);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        start();
    }

    @Override
    public void run() {
        if (monk1.getEnergy() > monk2.getEnergy()) {
            winners.add(monk1);
        } else {
            winners.add(monk2);
        }
    }
}
