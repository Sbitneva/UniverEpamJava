package sbitneva.homeworks.queue;

import java.util.LinkedList;
import java.util.Queue;

public class BigQ {
    private Queue<Integer> goodsWithPrice = new LinkedList<>();

    public BigQ(){

    }

    public BigQ(LinkedList<Integer> goodsWithPrice) {
        this.goodsWithPrice = goodsWithPrice;
    }

    public synchronized int poll() {
        return goodsWithPrice.poll();
    }

    public synchronized void put(int n) {
        goodsWithPrice.add(n);
    }

    public synchronized int size() {
        return goodsWithPrice.size();
    }
}
