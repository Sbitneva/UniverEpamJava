package app;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestParsePost {
    ParsePost parsePost;

    @Test
    public void doParseTest() throws Exception {
        parsePost = new ParsePost("7 6 *");
        assertTrue(42.0 == parsePost.doParse());
    }
}
