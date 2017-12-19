package sbitneva.homeworks.entities;

import org.apache.log4j.Logger;
import sbitneva.homeworks.queue.BigQ;

public class Thief extends Thread {
    private static Logger log = Logger.getLogger(Thief.class.getName());
    private BigQ    inputQueue;
    private Loader  loader;

    public Thief(BigQ inputQueue, Loader loader) {
        this.inputQueue = inputQueue;
        this.loader = loader;
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        log.debug("Total amount of assets is " + inputQueue.size());
        start();
    }

    @Override
    public void run() {
        while (inputQueue.size() > 0) {
            if (!loader.valueSet()) {
                int value = inputQueue.poll();
                loader.put(value);
                log.debug("Thief puts asset to Loader with value " + value);
            }
        }
        log.debug("END of Thief");
    }

    synchronized public BigQ getInputQueue() {
        return inputQueue;
    }
}
