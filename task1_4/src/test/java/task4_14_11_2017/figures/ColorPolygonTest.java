package task4_14_11_2017.figures;


import org.junit.Before;
import org.junit.Test;
import task4_14_11_2017.factories.ColorPolygonFactory;

import static org.junit.Assert.assertTrue;

public class ColorPolygonTest {
    private ColorPolygon colorPolygon;
    @Before public void createColorPolygon(){
        this.colorPolygon = ColorPolygonFactory.create();
    }
    @Test public void testPolygon(){
        Point polyArr[] = colorPolygon.getPolyPoints();
        for(int i = 0; i < polyArr.length; i++){
            assertTrue("null Point in ColorPolygon ", polyArr[i] != null);
        }
    }
}