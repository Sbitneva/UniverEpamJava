package sbitneva.homeworks;

import org.apache.log4j.Logger;
import org.junit.Test;
import sbitneva.homeworks.entities.Football;
import sbitneva.homeworks.factories.FootballFactory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestDB {
    private static Logger log = Logger.getLogger(Main.class.getName());

    @Test
    public void testDB() {
        Football football;
        try {
            football = FootballFactory.create("FOOTBALL", "localhost", 3306);
            assertTrue(football != null);

            String teamsBeforeAdding = football.showTeam();
            football.addTeam(6, "Dinamo");
            String teamsAfterAdding = football.showTeam();

            String playersBeforeAdding = football.showPlayers();
            football.addPlayer(4, 6, "Oleh", "Husev", 34);
            String playersAfterAdding = football.showPlayers();


            football.deletePlayer(4);
            String playersAfterDeleting = football.showPlayers();

            football.deleteTeam(6);
            String teamsAfterDeleting = football.showTeam();

            assertFalse(playersAfterAdding.equals(playersBeforeAdding));
            assertFalse(teamsBeforeAdding.equals(teamsAfterAdding));
            assertEquals(playersAfterDeleting, playersBeforeAdding);
            assertEquals(teamsAfterDeleting, teamsBeforeAdding);

            football.stop();
        } catch (Exception e) {
            log.error(e.getMessage());
        }

    }
}
