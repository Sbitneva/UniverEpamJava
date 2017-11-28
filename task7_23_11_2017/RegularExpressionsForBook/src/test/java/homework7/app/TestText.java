package homework7.app;

import homework7.app.entities.Text;
import homework7.app.entities.Word;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class TestText {
    @Test
    public void testGetSortedWords(){
        Text text = new Text("textTest");
        ArrayList<Word> words = text.getSortedWords();
        assertTrue(words.size() == 8);
        
    }
}
