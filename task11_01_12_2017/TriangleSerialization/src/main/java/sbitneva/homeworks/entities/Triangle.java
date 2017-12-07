package entities;

import java.awt.geom.Arc2D;
import java.io.*;

public class Triangle extends Figure implements Externalizable{
    private Point apexA, apexB, apexC;
    private Line sideAB, sideBC, sideAC;
    private double perimeter;
    private double square;

    private int id;
    public Triangle(){

    }
    public Triangle(Point apexA, Point apexB, Point apexC) {
        super();
        this.apexA = apexA;
        this.apexB = apexB;
        this.apexC = apexC;
        setSides();
        this.id = getId();
        perimeter = getPerimeter();
        square = getSquare();
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
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeObject(this.apexA);
        objectOutput.writeObject(this.apexB);
        objectOutput.writeObject(this.apexC);
        objectOutput.writeObject(this.sideAB);
        objectOutput.writeObject(this.sideAC);
        objectOutput.writeObject(this.sideBC);
        objectOutput.writeObject(this.perimeter);
        objectOutput.writeObject(this.square);
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        this.apexA = (Point)objectInput.readObject();
        this.apexB = (Point)objectInput.readObject();
        this.apexC = (Point)objectInput.readObject();
        this.sideAB = (Line)objectInput.readObject();
        this.sideAC = (Line)objectInput.readObject();
        this.sideBC = (Line)objectInput.readObject();
        this.perimeter = Double.parseDouble(objectInput.readObject().toString());
        this.square = Double.parseDouble(objectInput.readObject().toString());
    }

    @Override
    public boolean equals(Object o) {
        if(!(o.getClass() == this.getClass())){
            return false;
        }
        if(!(((Triangle)o).square == this.square)){
            return false;
        }
        if(!(((Triangle)o).perimeter == this.perimeter)){
            return false;
        }
        if(!(((Triangle)o).apexA.getX() == this.apexA.getX())){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "apexA=" + apexA +
                ", apexB=" + apexB +
                ", apexC=" + apexC +
                ", sideAB=" + sideAB +
                ", sideBC=" + sideBC +
                ", sideAC=" + sideAC +
                ", perimeter=" + perimeter +
                ", square=" + square +
                ", id=" + id +
                '}';
    }
}