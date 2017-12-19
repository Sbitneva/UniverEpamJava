package sbitneva.homeworks.factories;

import sbitneva.homeworks.entities.Football;

import java.sql.Connection;
import java.sql.DriverManager;

public class FootballFactory {
    private final static String CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    private final static String URL_PREFIX = "jdbc:mysql://";
    private final static String URL_COLON = ":";
    private final static String URL_SLASH = "/ ";
    private final static String URL_END = "?autoReconnect=true&useSSL=false";
    private final static String LOGIN_PASSWORD = "root";

    public static Football create(String dbName, String ip, int port) throws Exception {
        Football football = new Football();
        Class.forName(CLASS_NAME).newInstance();
        String url = URL_PREFIX + ip + URL_COLON + port + URL_SLASH + dbName + URL_END;
        Connection connection = DriverManager.getConnection(url, LOGIN_PASSWORD, LOGIN_PASSWORD);
        football.setCon(connection);
        return football;
    }
}
