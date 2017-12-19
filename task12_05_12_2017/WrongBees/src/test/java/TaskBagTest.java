import org.apache.log4j.Logger;
import org.junit.Test;
import sbitneva.homeworks.Main;
import sbitneva.homeworks.entities.Bee;
import sbitneva.homeworks.entities.Forest;
import sbitneva.homeworks.entities.Task;
import sbitneva.homeworks.entities.TaskQueue;

import java.util.Queue;

import static org.junit.Assert.assertEquals;

public class TaskBagTest {
    private static Logger log = Logger.getLogger(Bee.class.getName());

    @Test
    public void testTaskBag(){
        final String FOREST_FILE_PATH = "src/main/resources/forest_map.txt";
        final int ROWS_AMOUNT = 69;
        final int COLUMNS_AMOUNT = 1000;
        final int EXPECTED_ROW = 66;
        final int EXPECTED_COLUMN = 56;
        final int BEES_NUMBER = 10;

        Forest forest = new Forest(FOREST_FILE_PATH);
        TaskQueue taskQueue = forest.getTasks();

        assertEquals(taskQueue.size(), ROWS_AMOUNT);
        assertEquals(forest.getmColumns(), COLUMNS_AMOUNT);
        assertEquals(forest.getnRows(), ROWS_AMOUNT);

        for(int i = 0; i < BEES_NUMBER; i++){
            Main.beeQueue.add(new Bee(i, taskQueue));
            Main.beeQueue.get(i).start();
        }
        for (int i = 0; i < BEES_NUMBER; i++) {
            try {
                Main.beeQueue.get(i).join();
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
        }
        assertEquals(Main.row, EXPECTED_ROW);
        assertEquals(Main.column, EXPECTED_COLUMN);
    }
}
