package app;


import org.junit.Before;
import org.junit.Test;
import figures.*;

import static junit.framework.TestCase.assertFalse;

public class FiguresGeneratorTest {
    private FiguresGenerator figures;
    private Figure allFigures[];
    private Figure coloredFigures[];
    private Figure uncoloredFigures[];
    private Point points[];
    private ColorPoint coloredPoints[];
    private Line lines[] ;
    private ColorLine coloredLines[];
    private Triangle triangles[] ;
    private ColorTriangle coloredTriangles[] ;
    private Polygon polygons[];
    private ColorPolygon coloredPolygon[];

    @Before
    public void createFiguresSet(){
        this.figures = new FiguresGenerator();
        this.allFigures = figures.getFigures();

        this.coloredFigures = figures.getColoredFigures();
        this.uncoloredFigures = figures.getUncoloredFigures();
        this.points = figures.getPoints();
        this.coloredPoints = figures.getColoredPoints();
        this.lines = figures.getLines();
        this.coloredLines = figures.getColoredLines();
        this.triangles = figures.getTriangles();
        this.coloredTriangles = figures.getColoredTriangles();
        this.polygons = figures.getPolygons();
        this.coloredPolygon = figures.getColoredPolygons();
    }
    @Test
    public void testFiguresSet(){
        int fact_result = 0;
        if(coloredFigures != null){
            fact_result += coloredFigures.length;
        }
        if(uncoloredFigures != null){
            fact_result += uncoloredFigures.length;
        }
        int expected_result = allFigures.length;

        assertFalse("Grouping by colors error: ", (fact_result == expected_result) == false);
    }
    @Test
    public void testGroupsAmount(){
        int fact_result = 0;

        if(this.points != null ){
            fact_result += points.length;
        }
        if(this.coloredPoints != null ){
            fact_result += coloredPoints.length;
        }
        if(this.lines != null ){
            fact_result += lines.length;
        }
        if(this.coloredLines != null ){
            fact_result += coloredLines.length;
        }
        if(this.triangles != null ){
            fact_result += triangles.length;
        }
        if(this.coloredTriangles != null ){
            fact_result += coloredTriangles.length;
        }
        if(this.polygons != null ){
            fact_result += polygons.length;
        }
        if(this.coloredPolygon != null ){
            fact_result += coloredPolygon.length;
        }

        int expected_result = allFigures.length;

        assertFalse("Grouping by types error", (expected_result == fact_result) == false);
    }
}