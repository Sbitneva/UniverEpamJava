package sbitneva.homeworks.factories;

import sbitneva.homeworks.entities.Football;

import java.sql.Connection;
import java.sql.DriverManager;

public class FootballFactory {
    public static Football create(String dbName, String ip, int port) throws Exception {
        Football football = new Football();
        Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        String url = "jdbc:mysql://" + ip + ":" + port + "/ " + dbName + "?autoReconnect=true&useSSL=false";
        Connection connection = DriverManager.getConnection(url, "root", "root");
        football.setCon(connection);
        return football;
    }
}
