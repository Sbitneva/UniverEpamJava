package task2.factories;

import task2.vehicles.CCar;

import java.util.Random;

public class CCarConcreteFactory extends AbstractConcreteFactory {
    public static CCar create(){
        Random r = new Random();

        CCar car = new CCar(r.nextInt(10000) + 60000, r.nextInt(50) + 1968,
                new int[][]{{r.nextInt(100000000), r.nextInt(100000000)}},
                r.nextInt(220),
                r.nextInt(8));
        return car;
    }
}
