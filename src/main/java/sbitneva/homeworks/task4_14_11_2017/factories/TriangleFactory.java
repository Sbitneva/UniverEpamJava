package task4_14_11_2017.factories;

import task4_14_11_2017.figures.Point;
import task4_14_11_2017.figures.Triangle;

public class TriangleFactory {

    public static Triangle create(){
        Point apexA, apexB, apexC;
        apexA = PointFactory.create();
        apexB = PointFactory.create();
        apexC = PointFactory.create();

        return new Triangle(apexA, apexB, apexC);
    }
}
