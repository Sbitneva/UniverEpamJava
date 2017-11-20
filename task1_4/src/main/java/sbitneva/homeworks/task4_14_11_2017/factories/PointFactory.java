package task4_14_11_2017.factories;

import task4_14_11_2017.figures.Point;

import java.util.Random;

public class PointFactory extends AbstractConcreteFactory{

    public static Point create(){
        Random r = new Random();
        return new Point(r.nextInt(1000), r.nextInt(1000));
    }
}
