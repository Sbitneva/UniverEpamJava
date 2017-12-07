import entities.Triangle;
import factories.TriangleFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import static org.junit.Assert.assertEquals;

public class TestSerialization {
    @Test
    public void testSerialization(){
        Triangle triangle1 = TriangleFactory.create();
        Triangle triangle2 = null;
        try {
            FileOutputStream fileOut = new FileOutputStream("triangles.dat");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(triangle1);
            out.close();
            fileOut.close();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        try {
            FileInputStream fileIn = new FileInputStream("triangles.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            triangle2 = (Triangle) in.readObject();
            in.close();
            fileIn.close();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        assertEquals(triangle1, triangle2);
    }
}
