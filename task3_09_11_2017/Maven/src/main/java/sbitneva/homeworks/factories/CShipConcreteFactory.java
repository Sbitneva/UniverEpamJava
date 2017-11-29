package factories;

import vehicles.CShip;

import java.util.Random;

public class CShipConcreteFactory extends AbstractConcreteFactory {
    public static CShip create() {
        Random r = new Random();

        return new CShip(r.nextInt(3000000) + 1000000, r.nextInt(17) + 2000,
                        new int[][]{{r.nextInt(100000000), r.nextInt(100000000)}},
                        r.nextInt(200),"Newport");
    }
}
