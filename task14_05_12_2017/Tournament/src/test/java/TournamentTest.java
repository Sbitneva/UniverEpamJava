import org.junit.Test;
import sbitneva.homeworks.entities.Monk;
import sbitneva.homeworks.entities.Tournament;
import sbitneva.homeworks.factories.MonkFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.Queue;

public class TournamentTest {
    public Queue<Monk> monks = new LinkedList<>();
    public static Queue<Monk> winners = new LinkedList<>();

    @Test
    public void testTournament(){
        for(int i = 0; i < 31; i++){
            monks.add(MonkFactory.create());
        }
        Monk monkBest = new Monk();
        monkBest.setEnergy(2000);
        monkBest.setVillage("Kiev");
        monks.add(monkBest);
        while(winners.size() != 1){
            winners = Tournament.startTour(monks);
            monks = winners;
            System.out.println(winners.size());
            System.out.println(monks.size());
        }

        assertTrue((monks.peek()).equals(monkBest));
    }
}
