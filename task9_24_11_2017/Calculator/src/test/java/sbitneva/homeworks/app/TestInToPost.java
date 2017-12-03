package app;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestInToPost {

    InToPost inToPost;

    @Before
    public void init(){
        inToPost = new InToPost("3*2");
    }

    @Test
    public void doTransTest() throws Exception {
        String result = inToPost.doTrans();
        String expected = " 3 2 *";
        assertTrue(expected.equals(result));
    }

    @Test
    public void gotOperTest() throws Exception {
        inToPost.gotOper("*",1);
    }

    @Test
    public void gotParenTest() throws Exception {
        inToPost.gotParen("*");
    }
}
