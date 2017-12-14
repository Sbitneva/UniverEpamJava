package sbitneva.homeworks.entities;

import sbitneva.homeworks.Main;

public class Accountant extends Thread {
    private SmallQ middleQ;
    private int result;
    private int endCounter;

    public Accountant(SmallQ middleQ, int endCounter){
        this.endCounter = endCounter;
        this.middleQ = middleQ;
        try{
            sleep(2000);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
        start();
    }

    @Override
    public void run(){
        int n = 0;
        while(endCounter >= 0){
            if(middleQ.valueSet){
                result += middleQ.get();
                n++;
                System.out.println("Accountant got " + n + " asset");
                --endCounter;
            }
        }
        Main.end_calc = true;
        Main.result = result;
        System.out.println("Total value of assets is " +  result);
        System.out.println("END of Accountant " +  result);
        System.out.println("Main.end_calc = " +  Main.end_calc);
    }

}
