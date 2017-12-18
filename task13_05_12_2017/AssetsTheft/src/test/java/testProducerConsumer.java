import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.reflect.Whitebox;
import sbitneva.homeworks.Main;
import sbitneva.homeworks.entities.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.LinkedList;

import static org.junit.Assert.assertTrue;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Main.class})

public class testProducerConsumer {
    BigQ inputQueue;
    SmallQ middleQueue = new SmallQ();

    Thief thief;
    Accountant accountant;

    @Before
    public void init(){
        LinkedList <Integer> in  = new LinkedList<>();
        for(int i = 0; i < 10; i++){
            in.add(1);
        }
        inputQueue = new BigQ(in);
        thief = new Thief(inputQueue, middleQueue);
        accountant = new Accountant(middleQueue, inputQueue.size());

        try{
            thief.join();
            accountant.join();
        }catch(InterruptedException e){
            System.out.println(e.getMessage());
        }

        while (!Main.end_calc){

        }

        assertTrue(Main.result == 10);
    }

    @Test
    public void testResult(){

    }

}
