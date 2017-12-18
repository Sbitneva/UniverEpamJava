package sbitneva.homeworks;

import org.apache.log4j.Logger;
import sbitneva.homeworks.entities.Football;
import sbitneva.homeworks.factories.FootballFactory;

/**
 * Программа должна поддерживать выполнение следующих операций с
 * данными:
 *  добавление нового объекта
 *  изменение параметров существующего объекта
 *  удаление объекта
 *  поиск объектов по заданным критериям и вывод информации об
 * объектах
 * <p>
 * Объекты Команды, Игроки
 * <p>
 * Имеется множество футбольных
 * команд. Для каждой команды
 * определено множество игроков.
 */
public class Main {
    private static Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String args[]) {
        Football football = null;
        try {
            football = FootballFactory.create("FOOTBALL", "localhost", 3306);

            System.out.println("=======================");
            System.out.println("Teams table content :");
            System.out.println("=======================");
            System.out.println(football.showTeam());

            System.out.println("===================================================");
            System.out.println("Players table content :");
            System.out.println("===================================================");
            System.out.println(football.showPlayers());

            football.addTeam(6, "Dinamo");

            System.out.println("=======================");
            System.out.println("Teams table content :");
            System.out.println("=======================");
            System.out.println(football.showTeam());

            football.addPlayer(4, 6, "Oleh", "Husev", 34);

            System.out.println("===================================================");
            System.out.println("Players table content :");
            System.out.println("===================================================");
            System.out.println(football.showPlayers());

            football.deletePlayer(4);

            System.out.println("===================================================");
            System.out.println("Players table content :");
            System.out.println("===================================================");
            System.out.println(football.showPlayers());

            System.out.println("=======================");
            System.out.println("Teams table content :");
            System.out.println("=======================");
            System.out.println(football.showTeam());

            football.deleteTeam(6);

            System.out.println("=======================");
            System.out.println("Teams table content :");
            System.out.println("=======================");
            System.out.println(football.showTeam());

            football.stop();

        } catch (Exception e) {
            log.error(e.getMessage());
        }

    }

}
