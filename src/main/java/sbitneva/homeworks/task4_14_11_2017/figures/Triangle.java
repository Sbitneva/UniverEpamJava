package task4_14_11_2017.figures;

public class Triangle extends Figure{
    Point apexA, apexB, apexC;
    Line sideAB, sideBC, sideAC;
    private int id;
    public Triangle(Point apexA, Point apexB, Point apexC) {
        super();
        this.apexA = apexA;
        this.apexB = apexB;
        this.apexC = apexC;
        //sideAB= new Line(apexA, apexB);
        this.id = getId();
    }
    public Line getSideAB() {
        if (sideAB == null) sideAB = new Line(apexA, apexB);
        return sideAB;
    }
    public void setApexA(Point p) {
        apexA = p;
        sideAB = null;
        sideAC = null;
    }

    @Override
    public String toString() {
        return "\nFigure Type - " + this.getClass().getSimpleName() + "\t\t id = " + this.id;
    }
}