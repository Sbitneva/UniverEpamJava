package factories;

import figures.Point;
import figures.Polygon;

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
