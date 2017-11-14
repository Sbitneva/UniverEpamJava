package task2_07_11_2017.vehicles;

import task2_07_11_2017.interfaces.MoveAble;
import task2_07_11_2017.interfaces.SwimAble;

public class CAmphibianCar extends CVehicle implements SwimAble, MoveAble {
    public CAmphibianCar(Integer price, int yearIssue, int coords[][], int speed){
        super(price, yearIssue, coords, speed);
    }
    @Override
    public String move() {
        return "move";
    }

    @Override
    public String swim() {
        return "swim";
    }
}
