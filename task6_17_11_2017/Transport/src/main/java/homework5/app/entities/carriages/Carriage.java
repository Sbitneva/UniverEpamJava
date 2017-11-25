package homework5.app.entities.carriages;

public class Carriage {
    private static int id;
    public Carriage(){
        ++id;
    }

    public static int getId() {
        return id;
    }
}
