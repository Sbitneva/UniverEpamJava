package sbitneva.homeworks;

import sbitneva.homeworks.entities.*;
import sbitneva.homeworks.factories.RandomBigQFactory;

/**
 * inputQueue ->Thief -> middleQueue -> Loader -> outputQueue -> Accountant;
 */

public class Main{

    public static boolean end_calc = false;
    public static int result = 0;

    public static void main(String ... args){
        BigQ inputQueue = RandomBigQFactory.create();
        SmallQ middleQueue = new SmallQ();

        Thief thief = new Thief(inputQueue, middleQueue);
        Accountant accountant = new Accountant(middleQueue, inputQueue.size());
        try{
            thief.join();
            accountant.join();
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }

        while (!end_calc){

        }

        System.out.println("RESULT = " + result);

    }
}
