package homework5.app.entities;

public class Passenger {

    private static int id;
    private int currentId;
    private int baggageUnits;
    private String name;


    public Passenger(){
        ++id;
        this.currentId = id;
    }

    public Passenger(String name, int baggageUnits){
        ++id;
        this.currentId = id;
        this.name = name;
    }

    public int getId() {
        return currentId;
    }

    public int getBaggageUnits() {
        return baggageUnits;
    }

    public void setBaggageUnits(int baggageUnits) {
        this.baggageUnits = baggageUnits;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "\nPassenger{" +
                "id=" + currentId +
                ", baggageUnits=" + baggageUnits +
                ", name='" + name + '\'' +
                '}';
    }
}
