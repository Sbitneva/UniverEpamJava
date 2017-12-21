import org.junit.Test;
import sbitneva.homeworks.factories.RandomBigQFactory;
import sbitneva.homeworks.queue.BigQ;

import static org.junit.Assert.assertTrue;

public class TestFactory {

    @Test
    public void testFactory(){
        BigQ bigQ = RandomBigQFactory.create();
        assertTrue(bigQ.size() > 0);
    }
}
