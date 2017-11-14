package task2_07_11_2017.vehicles;

import task2_07_11_2017.interfaces.FlyAble;
import task2_07_11_2017.interfaces.MoveAble;
import task2_07_11_2017.interfaces.SwimAble;

public class CBatMobile extends CVehicle implements SwimAble, MoveAble, FlyAble {

    public CBatMobile(Integer price, int yearIssue, int[][] coords, int speed){
        super(price, yearIssue, coords, speed);
    }

    @Override
    public String swim() {
        return "swim";
    }

    @Override
    public String move() {
        return "move";
    }

    @Override
    public String fly() {
        return "fly";
    }
}
