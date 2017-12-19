package sbitneva.homeworks.entities;

import org.apache.log4j.Logger;
import sbitneva.homeworks.Main;

public class Accountant extends Thread {
    private static Logger log = Logger.getLogger(Accountant.class.getName());
    private Loader loader;
    private int result;
    private int endCounter;

    public Accountant(Loader loader, int endCounter) {
        this.endCounter = endCounter;
        this.loader = loader;
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
        start();
    }

    @Override
    public void run() {
        int n = 0;
        while (endCounter >= 0) {
            if (loader.valueSet()) {
                result += loader.get();
                n++;
                System.out.println("Accountant got " + n + " asset");
                --endCounter;
            }
        }
        Main.end_calc = true;
        Main.result = result;

        log.debug("Total value of assets is " + result);
        log.debug("END of Accountant " + result);
        log.debug("Main.end_calc = " + Main.end_calc);
    }

    synchronized public int getResult(){
        return this.result;
    }
}
