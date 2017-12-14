import org.junit.Test;
import sbitneva.homeworks.Main;
import sbitneva.homeworks.entities.Bee;
import sbitneva.homeworks.entities.Forest;
import sbitneva.homeworks.entities.Task;

import java.util.Queue;

import static org.junit.Assert.assertEquals;

public class TaskBagTest {

    @Test
    public void testTaskBag(){
        final int beesNumber = 10;

        Forest forest = new Forest("src/main/resources/forest_map.txt");
        Queue<Task> taskQueue = forest.getTasks();

        assertEquals(taskQueue.size(), 69);
        assertEquals(forest.getmColumns(), 1000);
        assertEquals(forest.getnRows(), 69);

        for(int i = 0; i < beesNumber; i++){
            Main.beeQueue.add(new Bee(i, taskQueue));
            Main.beeQueue.get(i).start();
        }

        for (int i = 0; i < beesNumber; i++) {
            try {
                Main.beeQueue.get(i).join();
            } catch (InterruptedException e) {

            }
        }

        assertEquals(Main.row, 66);
        assertEquals(Main.column, 56);
    }
}
