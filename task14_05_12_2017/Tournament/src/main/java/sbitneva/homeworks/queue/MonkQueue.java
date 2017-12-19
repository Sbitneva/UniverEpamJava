package sbitneva.homeworks.queue;

import sbitneva.homeworks.entities.Monk;

import java.util.LinkedList;
import java.util.Queue;

public class MonkQueue {
    private Queue<Monk> monkQ;

    public MonkQueue(){
        this.monkQ = new LinkedList<>();
    }

    public MonkQueue(Queue<Monk> monkQ){
        this.monkQ = monkQ;
    }

    public Queue<Monk> getMonkQ() {
        return monkQ;
    }

    synchronized public void add(Monk monk){
        monkQ.add(monk);
    }

    synchronized public int size(){
        return monkQ.size();
    }

    synchronized public Monk poll(){
        return monkQ.poll();
    }

    synchronized public Monk peek(){
        return monkQ.peek();
    }
}
