package task4_14_11_2017.figures;

import org.junit.Before;
import org.junit.Test;
import task4_14_11_2017.factories.TriangleFactory;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TriangleTest {
    private Triangle triangle1;
    private Triangle triangle2;

    @Before public void createTriangle(){
        triangle1 = new Triangle( new Point(1, 1), new Point(1, 1), new Point(2, 1));
        triangle2 = TriangleFactory.create();
    }
    @Test public void testValidation(){
        assertFalse("Triangle1 apexes are wrong", triangle1.isValid());
        assertTrue("Triangle2 apexes are wrong", triangle2.isValid());
    }

    @Test public void testSquare(){
        triangle1 = TriangleFactory.create();
        assertTrue("Triangle1 square wrong", triangle1.getSquare() > 0);
        assertTrue("Triangle2 square wrong", triangle2.getSquare() > 0);
    }
    @Test public void testPerimeter(){
        assertTrue("Triangle1 square wrong", triangle1.getPerimeter() > 0);
        assertTrue("Triangle2 square wrong", triangle2.getPerimeter() > 0);
    }
}