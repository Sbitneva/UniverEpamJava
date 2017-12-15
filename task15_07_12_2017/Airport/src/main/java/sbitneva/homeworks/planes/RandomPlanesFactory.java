package sbitneva.homeworks.planes;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class RandomPlanesFactory {
        public static Queue<Plane> create(){
            Random r = new Random();
            Queue<Plane> planes = new LinkedList<>();

            int n = r.nextInt(5) + 1;
            for(int i = 0; i < n; i++) {
                Plane plane = new Plane();
                plane.setCityName("City " + plane.getId());
                planes.add(plane);
            }
            return planes;
        }
}
