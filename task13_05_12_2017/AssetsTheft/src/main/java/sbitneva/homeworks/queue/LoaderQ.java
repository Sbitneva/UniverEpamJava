package sbitneva.homeworks.queue;

public class LoaderQ {
    private int     n;
    private boolean valueSet = false;

    public synchronized int get() {
        while (!valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Get exception - " + e.getMessage());
            }
        }
        System.out.println("gets " + n);
        valueSet = false;
        notify();
        return n;
    }

    public synchronized void put(int n) {
        while (valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Put exception - " + e.getMessage());
            }
        }
        System.out.println("puts " + n);
        this.n = n;
        valueSet = true;
        notify();
    }

    public synchronized boolean isValueSet() {
        return this.valueSet;
    }
}
