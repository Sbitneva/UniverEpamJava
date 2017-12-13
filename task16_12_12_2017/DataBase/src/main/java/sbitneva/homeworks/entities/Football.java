package sbitneva.homeworks.entities;

import org.apache.log4j.Logger;
import sbitneva.homeworks.Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Football {

    static Logger log = Logger.getLogger(Football.class.getName());
    private Connection con = null; // соединение с БД
    private PreparedStatement stmt = null;

    public Football(){

    }

    public Connection getCon() {
        return con;
    }

    public void stop() throws SQLException {
        con.close();
    }

    public void setCon(Connection con) {
        this.con = con;
    }


    public void addPlayer(int id_p, int id_t, String firstName, String secondName, int age){
        try {
            stmt = this.con.prepareStatement("INSERT INTO PLAYERS VALUES(?, ?, ?, ?, ?);");
            stmt.setInt(1, id_p);
            stmt.setInt(2, id_t);
            stmt.setString(3, firstName);
            stmt.setString(4, secondName);
            stmt.setInt(5, age);

            int i = stmt.executeUpdate();

            log.debug(i + "player is added");
        } catch(SQLException e){
            log.error(e.getMessage());
        }

    }

    public void deletePlayer(int id_p){
        try{
            stmt = con.prepareStatement("DELETE FROM PLAYERS WHERE ID_P = " + id_p);
            int i = stmt.executeUpdate();
            log.debug("player is deleted");
        }catch (SQLException e){
            log.error(e.getMessage());
        }
    }

    public void addTeam(int id_t, String name){
        try {
            stmt = this.con.prepareStatement("INSERT INTO TEAMS VALUES(?, ?);");
            stmt.setInt(1, id_t);
            stmt.setString(2, name);

            int i = stmt.executeUpdate();

            log.debug(i + "team is added");
        } catch(SQLException e){
            log.error(e.getMessage());
        }
    }

    public void deleteTeam(int id_t){
        try{
            stmt = con.prepareStatement("DELETE FROM TEAMS WHERE ID_T = " + 6);
            int i = stmt.executeUpdate();
            log.debug("TEAM is deleted");
        }catch (SQLException e){
            log.error(e.getMessage());
        }
    }

    public String showTeam(){
        try {
            stmt = this.con.prepareStatement("SELECT * FROM TEAMS;");
            ResultSet rs = stmt.executeQuery();
            StringBuilder res = new StringBuilder();
            while (rs.next()){
                res.append(rs.getInt(1));
                res.append("\t");
                res.append(rs.getString(2));
                res.append("\n");
            }
            return res.toString();
        } catch(SQLException e){
            log.error(e.getMessage());
        }
        return null;
    }

    public String showPlayers(){
        try {
            stmt = this.con.prepareStatement("SELECT * FROM PLAYERS;");
            ResultSet rs = stmt.executeQuery();
            StringBuilder res = new StringBuilder();
            res.append("ID_P\t").append("ID_T\t").append("First name\t").append("Second name\t").append("Age\n");
            while (rs.next()){
                res.append(rs.getInt(1));
                res.append("\t\t");
                res.append(rs.getInt(2));
                res.append("\t\t");
                res.append(rs.getString(3));
                res.append("\t");
                res.append(rs.getString(4));
                res.append("\t");
                res.append(rs.getString(5));
                res.append("\n");
            }
            return res.toString();
        } catch(SQLException e){
            log.error(e.getMessage());
        }
        return null;
    }
}
