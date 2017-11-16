package task4_14_11_2017.figures;

import org.junit.Before;
import org.junit.Test;
import task4_14_11_2017.factories.ColorTriangleFactory;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ColorTriangleTest {
    ColorTriangle colorTriangle;

    @Before public void createColoredTriangle(){
        colorTriangle = new ColorTriangle(new Point(1, 1), new Point(1, 1), new Point(2, 1), 122);
    }

    @Test public void testValidation(){
        assertFalse("ColorTriangle validation failed", colorTriangle.isValid());
        this.colorTriangle = ColorTriangleFactory.create();
        assertTrue("ColorTriangleFactory creation failed", colorTriangle.isValid());
    }

    @Test public void testSquare(){
        this.colorTriangle = ColorTriangleFactory.create();
        assertTrue("ColorTriangleFactory square wrong", colorTriangle.getSquare() > 0);
    }
    @Test public void testPerimeter(){
        this.colorTriangle = ColorTriangleFactory.create();
        assertTrue("ColorTriangleFactory perimeter wrong", colorTriangle.getPerimeter() > 0);
    }
}