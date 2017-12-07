import entities.Point;
import entities.Triangle;
import factories.TriangleFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String args[]){

        ArrayList<Triangle> triangles1 = new ArrayList<>();
        ArrayList<Triangle> triangles2 = new ArrayList<>();

        for(int i = 0; i < 10; i++){
            triangles1.add(TriangleFactory.create());
        }

        try {
            FileOutputStream fileOut = new FileOutputStream("triangles.dat");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            for(int i = 0; i < triangles1.size(); i++) {
                out.writeObject(triangles1.get(i));
            }
            out.close();
            fileOut.close();
        } catch (Exception e) {
            //e.printStackTrace();
            return;
        }
        try {
            FileInputStream fileIn = new FileInputStream("triangles.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            for(int i = 0; i < 10; i++) {
                triangles2.add((Triangle) in.readObject());
            }
            in.close();
            fileIn.close();
        } catch (Exception e) {
            //System.out.println(e.getMessage());
            return;
        }

        System.out.println(Arrays.toString(triangles1.toArray()));
        System.out.println(Arrays.toString(triangles2.toArray()));
    }
}
