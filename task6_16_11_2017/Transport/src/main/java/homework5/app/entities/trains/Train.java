package homework5.app.entities.trains;

public class Train {
    private static int id;
    public Train(){
        ++id;
    }

    public int getId() {
        return id;
    }
}

