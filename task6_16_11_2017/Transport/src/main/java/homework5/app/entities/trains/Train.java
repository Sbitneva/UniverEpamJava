package entities.trains;

public class Train {
    private static int id;
    public Train(){
        ++id;
    }

    public int getId() {
        return id;
    }
}

