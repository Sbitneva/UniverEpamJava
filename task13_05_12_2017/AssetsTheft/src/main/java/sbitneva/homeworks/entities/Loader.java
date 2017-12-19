package sbitneva.homeworks.entities;

import org.apache.log4j.Logger;
import sbitneva.homeworks.Main;
import sbitneva.homeworks.queue.LoaderQ;

public class Loader extends Thread {
    private static Logger   log = Logger.getLogger(Loader.class.getName());
    private LoaderQ loaderQ = new LoaderQ();

    public Loader() {
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        start();
    }

    @Override
    public void run() {
        while (!Main.end_calc) {
            try {
                sleep(10);
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
        return loaderQ.get();
    }

    public void put(int value) {
        loaderQ.put(value);
    }
}
