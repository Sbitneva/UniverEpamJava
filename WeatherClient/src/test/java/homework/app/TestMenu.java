import org.junit.Test;
import view.Menu;

import static org.junit.Assert.assertTrue;

public class TestMenu {
    Menu menu;

    @Test public void isMenuElementsVisible(){
        menu = new Menu();
        assertTrue("JFrame visibility problem", menu.getJf().isVisible());
    }


}
