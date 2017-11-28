package factories;

import figures.ColorPolygon;
import figures.Polygon;

import java.util.Random;

public class ColorPolygonFactory extends AbstractConcreteFactory{
    public static ColorPolygon create(){
        Random r = new Random();
        Polygon poly = PolygonFactory.create();

        return new ColorPolygon(poly.getPolyPoints(), r.nextInt(1000));
    }
}
