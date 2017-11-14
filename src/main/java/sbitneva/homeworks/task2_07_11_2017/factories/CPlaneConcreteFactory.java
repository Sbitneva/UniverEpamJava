package task2_07_11_2017.factories;

import task2_07_11_2017.vehicles.CPlane;

import java.util.Random;

public class CPlaneConcreteFactory extends AbstractConcreteFactory {
    public static CPlane create(){
        Random r = new Random();

        return new CPlane(r.nextInt(10000000) + 1000000, r.nextInt(30) + 1988,
                new int[][]{{r.nextInt(100000000), r.nextInt(100000000)}},
                r.nextInt(10000),
                r.nextInt(500), r.nextInt(15000));
    }
}
