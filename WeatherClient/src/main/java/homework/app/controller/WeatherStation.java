package controller;

import view.Menu;


public class WeatherStation {
    private Menu menu;
    public WeatherStation(){
        menu = new Menu();
    }
    public static void main(String[] args){
        WeatherStation ws = new WeatherStation();

    }

    public Menu getMenu() {
        return menu;
    }
}
