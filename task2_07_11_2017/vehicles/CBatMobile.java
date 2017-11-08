package task2.vehicles;

import task2.interfaces.FlyAble;
import task2.interfaces.MoveAble;
import task2.interfaces.SwimAble;

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
