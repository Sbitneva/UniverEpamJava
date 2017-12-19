package sbitneva.homeworks;

import org.apache.log4j.Logger;
import sbitneva.homeworks.entities.Football;
import sbitneva.homeworks.factories.FootballFactory;

/**
 * @autor Sbitneva Maria
 *
 * Программа должна поддерживать выполнение следующих операций с
 * данными:
 * - добавление нового объекта
 * - изменение параметров существующего объекта
 * - удаление объекта
 * - поиск объектов по заданным критериям и вывод информации об объектах
 *
 * Объекты: Команды, Игроки:
 *
 * Имеется множество футбольных
 * команд. Для каждой команды
 * определено множество игроков.
 *
 */

public class Main {
    private static Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String args[]) {
        Football football;
        try {
            football = FootballFactory.create("FOOTBALL", "localhost", 3306);
            log.debug("Teams table content :\n" + football.showTeam());
            log.debug("Players table content :\n" + football.showPlayers());

            football.addTeam(6, "Dinamo");

            log.debug("Teams table content :\n" + football.showTeam());

            football.addPlayer(4, 6, "Oleh", "Husev", 34);

            log.debug("Players table content :\n" + football.showPlayers());

            football.deletePlayer(4);

            log.debug("Players table content :\n" + football.showPlayers());
            log.debug("Teams table content :\n" + football.showTeam());

            football.deleteTeam(6);

            log.debug("Teams table content :\n" + football.showTeam());
            log.debug("Search Players by first and second name result :\n" +
                    football.searchPlayerByFirstAndSecondName("CHRISTIANO", "RONALDO"));

            football.stop();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
