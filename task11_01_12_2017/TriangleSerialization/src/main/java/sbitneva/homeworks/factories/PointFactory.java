package factories;

import entities.Point;

import java.util.Random;

public class PointFactory extends AbstractConcreteFactory{

    public static Point create(){
        Random r = new Random();
        return new Point(r.nextInt(1000), r.nextInt(1000));
    }
}
