package sbitneva.homeworks.entities;

import org.apache.log4j.Logger;
import sbitneva.homeworks.queue.LoaderQ;

public class Loader extends Thread {
    private static Logger   log = Logger.getLogger(Loader.class.getName());
    private LoaderQ loaderQ = new LoaderQ();
    private int counter;

    public Loader(int counter) {
        this.counter = counter;
        start();
    }

    @Override
    public void run() {
        while (counter > 0) {
            try {
                sleep(500);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
        }
        log.debug("END of LOADER");
    }

    public boolean valueSet() {
        return loaderQ.isValueSet();
    }

    public int get() {
        this.counter--;
        log.debug("Loader Counter = " + counter);
        return loaderQ.get();
    }

    public void put(int value) {
        loaderQ.put(value);
    }
}
