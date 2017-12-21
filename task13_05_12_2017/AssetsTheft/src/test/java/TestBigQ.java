import org.junit.Before;
import org.junit.Test;
import sbitneva.homeworks.queue.BigQ;

import static org.junit.Assert.assertEquals;

public class TestBigQ {

    private BigQ bigQ = new BigQ();

    @Before
    public void initBeforeTests(){
        bigQ.put(1);
        bigQ.put(2);
    }

    @Test
    public void testPut(){
        bigQ.put(3);
        assertEquals(bigQ.size(), 3);
    }

    @Test
    public void testPoll(){
        int n = bigQ.poll();
        assertEquals(n, 1);
    }

    @Test
    public void testSize(){
        int n = bigQ.size();
        assertEquals(n, 2);
    }

}
