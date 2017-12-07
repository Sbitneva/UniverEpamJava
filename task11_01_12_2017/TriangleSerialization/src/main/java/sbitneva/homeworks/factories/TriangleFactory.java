package factories;

import entities.Point;
import entities.Triangle;

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
