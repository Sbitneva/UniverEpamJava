import org.junit.Test;
import org.junit.Ignore;
import view.Menu;

import static org.junit.Assert.assertTrue;

public class TestMenu {
    Menu menu;

    @Ignore("Can't test GUI on CI job")
    @Test public void isMenuElementsVisible(){
        menu = new Menu();
        assertTrue("JFrame visibility problem", menu.getJf().isVisible());
    }


}
