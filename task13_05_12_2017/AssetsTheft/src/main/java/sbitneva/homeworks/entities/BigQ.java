package sbitneva.homeworks.entities;

import java.util.LinkedList;
import java.util.Queue;

public class BigQ {
    Queue<Integer> goodsWithPrice = null;
    public BigQ(){
        this.goodsWithPrice = new LinkedList<>();
    }
    public BigQ(LinkedList<Integer> goodsWithPrice){
        this.goodsWithPrice = goodsWithPrice;
    }

    public synchronized int poll(){
        int value = goodsWithPrice.poll();
        return value;
    }

    public synchronized void put(int n){
        goodsWithPrice.add(n);
    }

    public synchronized int size(){
        return goodsWithPrice.size();
    }
}
