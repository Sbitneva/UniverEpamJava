package task4_14_11_2017.app;

import java.util.Arrays;

public class Main {
    public static void main(String... args){
        FiguresGenerator figuresGenerator = new FiguresGenerator();
        System.out.println("Amount of created figures\t" + figuresGenerator.getFigures().length);
        System.out.println("\nAmount of colored figures\t" + figuresGenerator.getColoredFigures().length);
        System.out.println("Amount of uncolored figures\t" + figuresGenerator.getUncoloredFigures().length);
        System.out.println("\nPoints amount\t\t\t" +
                            (figuresGenerator.getPoints().length==0?"no points":figuresGenerator.getPoints().length));
        System.out.println("ColoredPoints amount\t" +
                (figuresGenerator.getColoredPoints().length==0?"no colored points":figuresGenerator.getColoredPoints().length));
        System.out.println("Lines amount\t\t\t" +
                (figuresGenerator.getLines().length==0?"no lines":figuresGenerator.getLines().length));
        System.out.println("ColoredLines amount\t\t" +
                (figuresGenerator.getColoredLines().length==0?"no colored lines":figuresGenerator.getColoredLines().length));
        System.out.println("Triangles amount\t\t" +
                (figuresGenerator.getTriangles().length==0?"no triangles":figuresGenerator.getTriangles().length));
        System.out.println("ColoredTriangles amount\t" +
                (figuresGenerator.getColoredTriangles().length==0?"no colored triangles":figuresGenerator.getColoredTriangles().length));
        System.out.println("Polygons amount\t\t\t" +
                (figuresGenerator.getPolygons().length==0?"no polygons":figuresGenerator.getPolygons().length));
        System.out.println("ColoredPolygons amount\t" +
                (figuresGenerator.getColoredPolygons().length==0?"no colored polygons":figuresGenerator.getColoredPolygons().length));
    }
}
