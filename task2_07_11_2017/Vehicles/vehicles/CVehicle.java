package hw2.vehicles;

public class CVehicle {
    private Integer price = 0;
    private int yearIssue = 0;
    private int coords[][] = new int[1][2];
    private int speed = 0;

    public CVehicle(){

    }

    public CVehicle(Integer price, int yearIssue, int coords[][], int speed){
        this.price = price;
        this.yearIssue = yearIssue;
        this.coords = coords;
        this.speed = speed;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public int getYearIssue() {
        return yearIssue;
    }

    public void setYearIssue(int yearIssue) {
        this.yearIssue = yearIssue;
    }

    public int[][] getCoords() {
        return coords;
    }

    public void setCoords(int[][] coords) {
        this.coords = coords;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
