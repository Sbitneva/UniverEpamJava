import org.apache.log4j.Logger;
import org.junit.Test;
import sbitneva.homeworks.entities.Monk;
import sbitneva.homeworks.entities.Tournament;
import sbitneva.homeworks.factories.MonkFactory;
import sbitneva.homeworks.queue.MonkQueue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TournamentTest {
    private static Logger log = Logger.getLogger(TournamentTest.class.getName());

    @Test
    public void testLogic(){

        MonkQueue monks = new MonkQueue();
        MonkQueue winners = new MonkQueue();

        for(int i = 0; i < 31; i++){
            monks.add(MonkFactory.create());
        }

        Monk bestMonk = new Monk();
        bestMonk.setName("Vasya");
        bestMonk.setVillage("Kiev");
        bestMonk.setEnergy(2000);

        monks.add(bestMonk);

        while(winners.size() != 1){
            winners = Tournament.startTour(monks);
            monks = winners;
        }

        assertEquals(winners.size(), 1);
        assertEquals(winners.peek(), bestMonk);
    }
}
