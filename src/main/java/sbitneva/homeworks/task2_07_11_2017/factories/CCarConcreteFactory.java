package task2_07_11_2017.factories;

import task2_07_11_2017.vehicles.CCar;

import java.util.Random;

public class CCarConcreteFactory extends AbstractConcreteFactory {
    public static CCar create(){
        Random r = new Random();

        return new CCar(r.nextInt(10000) + 60000, r.nextInt(50) + 1968,
                new int[][]{{r.nextInt(100000000), r.nextInt(100000000)}},
                r.nextInt(220),
                r.nextInt(8));
    }
}
