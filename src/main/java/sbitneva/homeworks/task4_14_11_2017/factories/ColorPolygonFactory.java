package task4_14_11_2017.factories;

import task4_14_11_2017.figures.ColorPolygon;
import task4_14_11_2017.figures.Polygon;

import java.util.Random;

public class ColorPolygonFactory {
    public static ColorPolygon create(){
        Random r = new Random();
        Polygon poly = PolygonFactory.create();

        return new ColorPolygon(poly.getPolyPoints(), r.nextInt(1000));
    }
}
