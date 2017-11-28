package task2_07_11_2017.vehicles;

import task2_07_11_2017.interfaces.SwimAble;

public class CShip extends CVehicle implements SwimAble {
    private String portName = "Unnamed Port";

    public CShip(Integer price, int yearIssue, int coords[][], int speed,  String portName){
        super(price, yearIssue, coords, speed);
        this.portName = portName;
    }

    @Override
    public String swim(){
        return "Swim";
    }

    public String getPortName() {
        return portName;
    }

    public void setPortName(String portName) {
        this.portName = portName;
    }
}
