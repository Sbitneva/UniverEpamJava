package sbitneva.homeworks.entities;

import org.apache.log4j.Logger;

public class Accountant extends Thread {
    private static Logger log = Logger.getLogger(Accountant.class.getName());
    private Loader loader;
    private int result;
    private int endCounter;

    public Accountant(Loader loader, int endCounter) {
        this.endCounter = endCounter;
        this.loader = loader;
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        start();
    }

    @Override
    public void run() {
        while (endCounter > 0) {
            if (loader.valueSet()) {
                result += loader.get();
                endCounter--;
            }
        }
        log.debug("Total value of assets is " + result);
        log.debug("END of Accountant " + result);
    }

    synchronized public int getResult(){
        return this.result;
    }
}
