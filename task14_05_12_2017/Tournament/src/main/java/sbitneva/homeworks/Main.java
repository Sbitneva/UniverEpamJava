package sbitneva.homeworks;

import org.apache.log4j.Logger;
import sbitneva.homeworks.entities.Tournament;
import sbitneva.homeworks.factories.MonkFactory;
import sbitneva.homeworks.queue.MonkQueue;

public class Main {
    private static Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String args[]){
        MonkQueue monks = new MonkQueue();
        MonkQueue winners = new MonkQueue();

        for(int i = 0; i < 32; i++){
            monks.add(MonkFactory.create());
        }

        while(winners.size() != 1){
            winners = Tournament.startTour(monks);
            monks = winners;
            log.debug(winners.size());
            log.debug(monks.size());
        }
        log.debug("Winner of the Tournament is..." + winners.peek().toString());
    }
}
