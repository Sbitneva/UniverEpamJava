package interfaces;

public interface Observer {
    public void update(double temperature, int pressure, int humidity);
    public void restart();
}
