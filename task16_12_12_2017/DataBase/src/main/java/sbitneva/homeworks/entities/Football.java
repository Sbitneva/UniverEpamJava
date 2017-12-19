package sbitneva.homeworks.entities;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Football {
    private static Logger log = Logger.getLogger(Football.class.getName());
    private Connection con = null;
    private PreparedStatement stmt = null;

    public Football() {

    }

    final public void stop() throws SQLException {
        con.close();
    }

    final public void setCon(Connection con) {
        this.con = con;
    }


    public void addPlayer(int id_p, int id_t, String firstName, String secondName, int age) {
        final String REQUEST = "INSERT INTO PLAYERS VALUES(?, ?, ?, ?, ?);";
        try {
            stmt = this.con.prepareStatement(REQUEST);
            stmt.setInt(1, id_p);
            stmt.setInt(2, id_t);
            stmt.setString(3, firstName);
            stmt.setString(4, secondName);
            stmt.setInt(5, age);
            int i = stmt.executeUpdate();

            log.debug(i + "player is added");
        } catch (SQLException e) {
            log.error(e.getMessage());
        }

    }

    public void deletePlayer(int id_p) {
        final String REQUEST = "DELETE FROM PLAYERS WHERE ID_P = ";
        try {
            stmt = con.prepareStatement(REQUEST + id_p);
            stmt.executeUpdate();
            log.debug("player is deleted");
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }

    public void addTeam(int id_t, String name) {
        final String REQUEST = "INSERT INTO TEAMS VALUES(?, ?);";
        try {
            stmt = this.con.prepareStatement(REQUEST);
            stmt.setInt(1, id_t);
            stmt.setString(2, name);

            int i = stmt.executeUpdate();

            log.debug(i + "teams are added");
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }

    public void deleteTeam(int id_t) {
        final String REQUEST = "DELETE FROM TEAMS WHERE ID_T = ";
        try {
            stmt = con.prepareStatement(REQUEST + 6);
            int i = stmt.executeUpdate();
            log.debug(i + "teams are deleted");
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }

    public String showTeam() {
        final String REQUEST = "SELECT * FROM TEAMS;";
        try {
            stmt = this.con.prepareStatement(REQUEST);
            ResultSet rs = stmt.executeQuery();
            StringBuilder res = new StringBuilder();
            while (rs.next()) {
                res.append(rs.getInt(1));
                res.append("\t");
                res.append(rs.getString(2));
                res.append("\n");
            }
            return res.toString();
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return null;
    }

    public String showPlayers() {
        final String REQUEST = "SELECT * FROM PLAYERS;";
        try {
            stmt = this.con.prepareStatement(REQUEST);
            ResultSet rs = stmt.executeQuery();
            StringBuilder res = new StringBuilder();
            res.append("ID_P\t").append("ID_T\t").append("First_name\t\t").append("Second_name\t\t").append("Age\n");
            while (rs.next()) {
                res.append(rs.getInt(1));
                res.append("\t\t");
                res.append(rs.getInt(2));
                res.append("\t\t");
                res.append(rs.getString(3));
                res.append("\t\t\t");
                res.append(rs.getString(4));
                res.append("\t\t");
                res.append(rs.getString(5));
                res.append("\n");
            }
            return res.toString();
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        return null;
    }

    public String searchPlayerByFirstAndSecondName(String firstName, String secondName) {
        final String REQUEST = "SELECT * FROM PLAYERS WHERE (FIRST_NAME='" + firstName +
                "' AND SECOND_NAME='" + secondName + "');";
        StringBuilder res = new StringBuilder();
        try {
            stmt = this.con.prepareStatement(REQUEST);
            ResultSet rs = stmt.executeQuery();
            res.append("ID_P\t").append("ID_T\t").append("First_name\t\t").append("Second_name\t\t").append("Age\n");
            while(rs.next()){
                res.append(rs.getInt(1));
                res.append("\t\t");
                res.append(rs.getInt(2));
                res.append("\t\t");
                res.append(rs.getString(3));
                res.append("\t\t\t");
                res.append(rs.getString(4));
                res.append("\t\t");
                res.append(rs.getString(5));
                res.append("\n");
            }
        } catch (SQLException e){
            log.error(e.getMessage());
        }
        return res.toString();
    }
}
