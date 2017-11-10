package task2.vehicles;

import task2.interfaces.FlyAble;

public class CPlane extends CVehicle implements FlyAble {
    private int passengersAmount = 0;
    private int flightAltitude = 0;


    public CPlane(int price, int yearIssue, int coords[][], int speed, int passengersAmount, int flightAltitude){
        super(price, yearIssue, coords, speed);
        this.passengersAmount = passengersAmount;
        this.flightAltitude = flightAltitude;
    }

    public int getPassengersAmount() {
        return passengersAmount;
    }

    public void setPassengersAmount(int passengersAmount) {
        this.passengersAmount = passengersAmount;
    }

    public int getFlightAltitude() {
        return flightAltitude;
    }

    public void setFlightAltitude(int flightAltitude) {
        this.flightAltitude = flightAltitude;
    }

    @Override
    public String fly(){
        return "Fly";
    }
}
