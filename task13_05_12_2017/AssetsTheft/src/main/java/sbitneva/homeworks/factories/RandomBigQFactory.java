package sbitneva.homeworks.factories;

import sbitneva.homeworks.queue.BigQ;

import java.util.LinkedList;
import java.util.Random;

public class RandomBigQFactory {

    public static BigQ create() {
        LinkedList<Integer> prices = new LinkedList<>();
        Random r = new Random();
        int queue_size = r.nextInt(100);

        for (int i = 0; i < queue_size; i++) {
            prices.add(r.nextInt(4000));
        }
        BigQ bigQ = new BigQ(prices);
        return bigQ;
    }
}
