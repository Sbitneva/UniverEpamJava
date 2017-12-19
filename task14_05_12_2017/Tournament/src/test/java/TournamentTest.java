import org.apache.log4j.Logger;
import org.junit.Test;
import sbitneva.homeworks.entities.Monk;
import sbitneva.homeworks.entities.Tournament;
import sbitneva.homeworks.factories.MonkFactory;
import sbitneva.homeworks.queue.MonkQueue;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;

public class TournamentTest {
    private static Logger log = Logger.getLogger(TournamentTest.class.getName());

    @Test
    public void testLogic() {

        MonkQueue   monks    = new MonkQueue();
        MonkQueue   winners  = new MonkQueue();
        Monk        bestMonk = new Monk();

        for (int i = 0; i < 31; i++) {
            monks.add(MonkFactory.create());
        }

        bestMonk.setName("Vasya");
        bestMonk.setVillage("Kiev");
        bestMonk.setEnergy(2000);

        monks.add(bestMonk);

        Tournament tournament = new Tournament(monks);
        while (winners.size() != 1) {
            try {
                sleep(500);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
            if (!tournament.isAlive()) {
                winners = tournament.getWinners();
                monks = winners;
                tournament = new Tournament(monks);
            }
        }

        assertEquals(winners.size(), 1);
        assertEquals(winners.peek(), bestMonk);
    }
}
