package task2_07_11_2017.factories;

import task2_07_11_2017.vehicles.CBatMobile;

import java.util.Random;

public class CBatMobileConcreteFactory extends AbstractConcreteFactory {
    public static CBatMobile create(){
        Random r = new Random();

        return new CBatMobile(r.nextInt(500000) + 1000000, r.nextInt(30) + 1988,
                                new int[][]{{r.nextInt(100000000), r.nextInt(100000000)}}, r.nextInt(5000));
    }
}
