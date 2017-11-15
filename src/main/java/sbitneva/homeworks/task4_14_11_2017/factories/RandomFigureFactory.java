package task4_14_11_2017.factories;

import task4_14_11_2017.figures.Figure;

import java.util.Random;

public class RandomFigureFactory {
    public static Figure create(){
        Random r = new Random();
        switch (r.nextInt(7)){
            case 0:
                return PointFactory.create();
            case 1:
                return ColorPointFactory.create();
            case 2:
                return LineFactory.create();
            case 3:
                return ColorLineFactory.crete();
            case 4:
                return TriangleFactory.create();
            case 5:
                return ColorTriangleFactory.create();
            case 6:
                return PolygonFactory.create();
            case 7:
                return ColorPolygonFactory.create();
            default:
                return null;
        }
    }
}
