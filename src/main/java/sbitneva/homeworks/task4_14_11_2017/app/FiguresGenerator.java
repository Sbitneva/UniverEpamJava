package task4_14_11_2017.app;

import task4_14_11_2017.factories.RandomFigureFactory;
import task4_14_11_2017.figures.*;
import task4_14_11_2017.interfaces.Colored;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * 1. создать последовательность из фигур используя фабрики цветных и нецветных фигур
 * 2. получить масивы цветных и не цветных и сколько каждых фигур в нем присутсвует
 * 3. групируем в масивах фигуры
 *
 * @author Sbitneva Maria
 */

public class FiguresGenerator {

    private Figure figures[] = null;
    private int size;

    private Figure uncoloredFigures[] = null;
    private Figure coloredFigures[] = null;

    private Point points[] = null;
    private ColorPoint coloredPoints[] = null;

    private Line lines[] = null;
    private ColorLine coloredLines[] = null;

    private Triangle triangles[] = null;
    private ColorTriangle coloredTriangles[] = null;

    private Polygon polygons[] = null;
    private ColorPolygon coloredPolygons[] = null;



    public FiguresGenerator(){
       Random r = new Random();
       this.size = r.nextInt(1000);
       figures = new Figure[size];

       for(int i = 0; i < size; i++){
           figures[i] = RandomFigureFactory.create();
       }

       this.uncoloredFigures = getUncoloredFigures();
       this.coloredFigures = getColoredFigures();
    }

    public Figure[] getColoredFigures(){
        if(this.coloredFigures == null){
            List<Figure> figureList = new LinkedList<>();
            for(int i = 0; i < this.size; i++){
                if(figures[i] instanceof Colored){
                    figureList.add(figures[i]);
                }
            }
            this.coloredFigures = figureList.toArray(new Figure[figureList.size()]);
        }

        return this.coloredFigures;
    }

    public Figure[] getUncoloredFigures(){
        if (this.uncoloredFigures == null) {
            List<Figure> figureList = new LinkedList<>();
            for(int i = 0; i < this.size; i++){
                if((this.figures[i] instanceof Colored) == false){
                    figureList.add(figures[i]);
                }
            }
            this.uncoloredFigures = figureList.toArray(new Figure[figureList.size()]);
        }
        return this.uncoloredFigures;
    }

    public Point[] getPoints(){
        if(points == null){
            List<Point> pointsList = new LinkedList<>();
            for(int i = 0; i < uncoloredFigures.length; i++){
                if(uncoloredFigures[i] instanceof Point){
                    pointsList.add((Point)uncoloredFigures[i]);
                }
            }
            this.points = pointsList.toArray(new Point[pointsList.size()]);
        }
        return this.points;
    }

    public ColorPoint[] getColoredPoints(){
        if(coloredPoints == null){
            List<ColorPoint> pointsList = new LinkedList<>();
            for(int i = 0; i < coloredFigures.length; i++){
                if(coloredFigures[i] instanceof ColorPoint){
                    pointsList.add((ColorPoint)coloredFigures[i]);
                }
            }
            this.coloredPoints = pointsList.toArray(new ColorPoint[pointsList.size()]);
        }
        return this.coloredPoints;
    }

    public Line[] getLines() {
        if(this.lines == null){
            List<Line> lineList = new LinkedList<>();

            for(int i = 0; i < this.uncoloredFigures.length; i++){
                if(this.uncoloredFigures[i] instanceof Line){
                    lineList.add((Line) this.uncoloredFigures[i]);
                }
            }
            this.lines = lineList.toArray(new Line[lineList.size()]);
        }
        return this.lines;
    }

    public ColorLine[] getColoredLines() {
        if(this.coloredLines == null){
            List<ColorLine> lineList = new LinkedList<>();

            for(int i = 0; i < this.coloredFigures.length; i++){
                if(this.coloredFigures[i] instanceof ColorLine){
                    lineList.add((ColorLine) this.coloredFigures[i]);
                }
            }
            this.coloredLines = lineList.toArray(new ColorLine[lineList.size()]);

        }

        return this.coloredLines;
    }

    public Triangle[] getTriangles() {
        if(triangles == null){
            List<Triangle> triList = new LinkedList<>();
            for(int i = 0; i < uncoloredFigures.length; i++){
                if(uncoloredFigures[i] instanceof Triangle){
                    triList.add((Triangle)uncoloredFigures[i]);
                }
            }
            this.triangles = triList.toArray(new Triangle[triList.size()]);
        }
        return this.triangles;
    }

    public ColorTriangle[] getColoredTriangles() {
        if(triangles == null){
            List<ColorTriangle> triList = new LinkedList<>();
            for(int i = 0; i < uncoloredFigures.length; i++){
                if(uncoloredFigures[i] instanceof ColorTriangle){
                    triList.add((ColorTriangle)uncoloredFigures[i]);
                }
            }
            this.coloredTriangles = triList.toArray(new ColorTriangle[triList.size()]);
        }
        return this.coloredTriangles;
    }

    public Polygon[] getPolygons(){
        if(this.polygons == null){
            List<Polygon> polygonsList = new LinkedList<>();

            for(int i = 0; i < this.coloredFigures.length; i++){
                if(this.coloredFigures[i] instanceof Polygon){
                    polygonsList.add((Polygon) this.coloredFigures[i]);
                }
            }
            this.polygons = polygonsList.toArray(new Polygon[polygonsList.size()]);
        }
        return this.polygons;
    }

    public ColorPolygon[] getColoredPolygons(){
        if(this.coloredPolygons == null){
            List<ColorPolygon> colPolygonsList = new LinkedList<>();

            for(int i = 0; i < this.coloredFigures.length; i++){
                if(this.coloredFigures[i] instanceof ColorPolygon){
                    colPolygonsList.add((ColorPolygon) this.coloredFigures[i]);
                }
            }
            this.coloredPolygons = colPolygonsList.toArray(new ColorPolygon[colPolygonsList.size()]);
        }
        return this.coloredPolygons;
    }
}
