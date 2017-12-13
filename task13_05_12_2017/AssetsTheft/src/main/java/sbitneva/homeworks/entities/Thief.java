package sbitneva.homeworks.entities;

public class Thief extends Thread {
    BigQ inputQueue;
    SmallQ middleQ;

    public Thief(BigQ inputQueue, SmallQ middleQ){
        this.inputQueue = inputQueue;
        this.middleQ = middleQ;
        try{
            sleep(2000);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }

        System.out.println("Total amount of assets is " + inputQueue.size() );
        start();
    }

    @Override
    public void run(){
        while(inputQueue.size() > 0){
            if(!middleQ.valueSet){
                int value = inputQueue.poll();
                middleQ.put(value);
                System.out.println("Thief puts asset to Loader with value "+ value);
            }
        }
        System.out.println("END of Thief");
    }
}
