package app;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class StackXTest {

    StackX stack;
    @Before
    public void init(){
        stack = new StackX(10);
        stack.push("16");
        stack.push("*");
        stack.push("10");
    }

    @Test
    public void pushTest() throws Exception {
        assertTrue(stack.size() == 3);
    }

    @Test
    public void popTest() throws Exception {
        stack.pop();
        assertTrue(stack.size() == 2);
    }

    @Test
    public void peekTest() throws Exception {
        assertTrue(stack.peek() == "10");
    }

    @Test
    public void isEmptyTest() throws Exception {
        assertTrue(!stack.isEmpty());
    }

}
