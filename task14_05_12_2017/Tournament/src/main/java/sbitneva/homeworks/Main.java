package sbitneva.homeworks;

import org.apache.log4j.Logger;
import sbitneva.homeworks.entities.Tournament;
import sbitneva.homeworks.factories.MonkFactory;
import sbitneva.homeworks.queue.MonkQueue;

import static java.lang.Thread.sleep;

/**
 * @author Sbitneva Maria
 *
 * Задача о Пути Кулака.
 * На седых склонах Гималаев стоят два древних буддистских монастыря:
 * Гуань-Инь и Гуань-Янь. Каждый год в день сошествия на землю боддисатвы Араватти монахи обоих
 * монастырей собираются на совместное празднество и показывают свое совершенствование на Пути Кулака.
 * Всех соревнующихся монахов разбивают на пары, победители пар бьются затем между собой и так далее,
 * до финального поединка. Монастырь, монах которого победил в финальном бою,
 * забирает себе на хранение статую боддисатвы. Реализовать многопоточное приложение,
 * определяющего победителя. В качестве входных данных используется массив,
 * в котором хранится количество энергии Ци каждого монаха.
 * При решении использовать принцип дихотомии.
 *
 */

public class Main {
    private static Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String args[]) {
        MonkQueue monks     = new MonkQueue();
        MonkQueue winners   = new MonkQueue();

        for (int i = 0; i < 32; i++) {
            monks.add(MonkFactory.create());
        }

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
                log.debug(winners.size());
                log.debug(monks.size());
            }
        }
        log.debug("Winner of the Tournament is..." + winners.peek().toString());
    }
}
