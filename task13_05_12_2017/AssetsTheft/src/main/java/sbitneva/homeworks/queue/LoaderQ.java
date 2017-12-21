package sbitneva.homeworks.queue;

import org.apache.log4j.Logger;

public class LoaderQ {
    private static Logger log = Logger.getLogger(LoaderQ.class.getName());
    private int     n;
    private boolean valueSet = false;

    public synchronized int get() {
        while (!valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
        }
        valueSet = false;
        notify();
        return n;
    }

    public synchronized void put(int n) {
        while (valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
        }
        this.n = n;
        valueSet = true;
        notify();
    }

    public synchronized boolean isValueSet() {
        return this.valueSet;
    }
}
