package hw2.vehicles;

import hw2.interfaces.MoveAble;

public class CCar extends CVehicle implements MoveAble {
    private int passengersAmount = 0;

    public CCar(Integer price, int yearIssue, int[][] coords, int speed, int passengersAmount){
        super(price, yearIssue, coords, speed);
        this.passengersAmount = passengersAmount;
    }
    @Override
    public String move(){
        return "move";
    }

    public int getPassengersAmount() {
        return passengersAmount;
    }

    public void setPassengersAmount(int passengersAmount) {
        this.passengersAmount = passengersAmount;
    }
}
