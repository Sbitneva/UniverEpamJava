package task4_14_11_2017.factories;

import task4_14_11_2017.figures.Point;
import task4_14_11_2017.figures.Polygon;

import java.util.Random;

public class PolygonFactory extends AbstractConcreteFactory {
    public static Polygon create(){
        Random r = new Random();
        int n = r.nextInt(100);
        Point polyArr[] = new Point[n];

        for(int i = 0; i < n; i++){
            polyArr[i] = PointFactory.create();
        }

        return new Polygon(polyArr);
    }
}
