package sbitneva.homeworks.entities;

import org.apache.log4j.Logger;
import sbitneva.homeworks.Main;
import sbitneva.homeworks.queue.MonkQueue;

public class Tournament{
    private static Logger log = Logger.getLogger(Main.class.getName());
    private static int tour_id = 0;

    public static MonkQueue startTour(MonkQueue monks){
        MonkQueue winners = new MonkQueue();
        tour_id++;
        log.debug("Tour # " + tour_id + "starts");

        while(monks.size() > 0){
            try{
                Monk monk1 = monks.poll();
                Monk monk2 = monks.poll();
                log.debug(monk1.getName() + " : " + monk2.getName());
                new Tour(monk1, monk2, winners).join();
            }catch (InterruptedException e){
                log.error(e.getMessage());
            }
        }
        return winners;
    }

}
