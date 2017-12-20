import org.apache.log4j.Logger;
import org.junit.Test;
import sbitneva.homeworks.entities.*;
import sbitneva.homeworks.queue.BigQ;
import static org.junit.Assert.assertEquals;


public class TestProducerConsumer {

    private static Logger log = Logger.getLogger(TestProducerConsumer.class.getName());

    @Test
    public void testLogic(){

        final int STOCK_SIZE = 10;
        BigQ inputQueue = new BigQ();

        for(int i = 0; i < STOCK_SIZE; i++){
            inputQueue.put(1);
        }

        assertEquals(inputQueue.size(), STOCK_SIZE);

        Loader      loader = new Loader(inputQueue.size()); // Pertov
        Thief       thief = new Thief(inputQueue, loader); // Ivanov
        Accountant  accountant = new Accountant(loader, inputQueue.size()); // Necheporchyk

        try {
            thief.join();
            loader.join();
            accountant.join();
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }

        while (inputQueue.size() > 0) {
            try {
                Thread.sleep(500);
            }catch(InterruptedException e){
                log.error(e.getMessage());
            }
        }

        assertEquals(accountant.getResult(), 10);
    }
}
