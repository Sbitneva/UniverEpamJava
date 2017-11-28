package factories;

import figures.Point;
import figures.Triangle;

public class TriangleFactory extends AbstractConcreteFactory{

    public static Triangle create(){
        Point apexA, apexB, apexC;
        apexA = PointFactory.create();
        apexB = PointFactory.create();
        apexC = PointFactory.create();

        Triangle triangle = new Triangle(apexA, apexB, apexC);
        while(!triangle.isValid()){
            triangle.setApexA(PointFactory.create());
        }

        return triangle;
    }
}
