package task4_14_11_2017.figures;

public class Triangle extends Figure{
    Point apexA, apexB, apexC;
    Line sideAB, sideBC, sideAC;
    private double perimeter;
    private double square;

    private int id;
    public Triangle(Point apexA, Point apexB, Point apexC) {
        super();
        this.apexA = apexA;
        this.apexB = apexB;
        this.apexC = apexC;
        setSides();
        this.id = getId();
    }
    private void setSides(){
        this.sideAB = new Line(apexA, apexB);
        this.sideAC = new Line(apexA, apexC);
        this.sideBC = new Line(apexB, apexC);
    }
    public Line getSideAB() {
        return sideAB;
    }
    public Line getSideAC() {
        return this.sideAC;
    }
    public Line getSideBC() {
        return sideBC;
    }
    public void setApexA(Point p) {
        apexA = p;
        setSides();
    }

    public void setApexB(Point apexB) {
        this.apexB = apexB;
        setSides();
    }

    public void setApexC(Point apexC) {
        this.apexC = apexC;
        setSides();
    }
    private double getSideLen(Line side){
        double sideLen = Math.sqrt(
                        (side.getBeg().getX() - side.getEnd().getX()) *
                        (side.getBeg().getX() - side.getEnd().getX()) +
                        (side.getBeg().getY() - side.getEnd().getY()) *
                        (side.getBeg().getY() - side.getEnd().getY())
        );

        return sideLen;
    }
    public double getPerimeter(){
        this.perimeter = getSideLen(sideAB) + getSideLen(sideBC) + getSideLen(sideAC);
        return this.perimeter;
    }
    public double getSquare(){
        double p = getPerimeter() / 2;
        this.square = Math.sqrt(p * ((p - getSideLen(sideAB)) * (p - getSideLen(sideBC)) * (p - getSideLen(sideAC))));
        return this.square;
    }
    public boolean isValid(){
        if((this.apexA == this.apexB) || (this.apexA == this.apexC) || (this.apexB == apexC)){
            return false;
        }
        if((this.apexB.getX() == this.apexA.getX()) && (this.apexC.getX() == this.apexA.getX())){
            return false;
        }
        if((this.apexB.getY() == this.apexA.getY()) && (this.apexC.getY() == this.apexA.getY())){
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "\nFigure Type - " + this.getClass().getSimpleName() + "\t\t id = " + this.id;
    }
}