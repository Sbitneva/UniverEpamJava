package task4_14_11_2017.app;

import task4_14_11_2017.figures.*;

import java.util.Arrays;

public class Main {
    public static void main(String... args){
        FiguresGenerator figures = new FiguresGenerator();
        Figure coloredFigures[] = figures.getColoredFigures();
        Figure uncoloredFigures[] = figures.getUncoloredFigures();
        Point points[] = figures.getPoints();
        ColorPoint coloredPoints[] = figures.getColoredPoints();
        Line lines[] = figures.getLines();
        ColorLine coloredLines[] = figures.getColoredLines();
        Triangle triangles[] = figures.getTriangles();
        ColorTriangle coloredTriangles[] = figures.getColoredTriangles();
        Polygon polygons[] = figures.getPolygons();
        ColorPolygon coloredPolygon[] = figures.getColoredPolygons();
        //System.out.print(Arrays.deepToString(coloredFigures));
        //System.out.print(Arrays.deepToString(uncoloredFigures));
        //System.out.print(Arrays.deepToString(points));
        //System.out.print(Arrays.deepToString(coloredPoints));
        //System.out.print(Arrays.deepToString(lines));
        //System.out.print(Arrays.deepToString(coloredLines));
        //System.out.print(Arrays.deepToString(triangles));
        //System.out.print(Arrays.deepToString(coloredTriangles));
        //System.out.print(Arrays.deepToString(polygons));
        //System.out.print(Arrays.deepToString(coloredPolygon));

    }
}
