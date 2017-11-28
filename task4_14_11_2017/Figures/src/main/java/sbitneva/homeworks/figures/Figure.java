package figures;

public class Figure {
    static public int id;
    public Figure(){
        this.id++;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "\nFigure Type - " + this.getClass().getSimpleName() + "\t\t id = " + this.id;
    }
}
