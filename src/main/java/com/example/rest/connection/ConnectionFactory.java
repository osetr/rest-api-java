package com.example.rest.dao;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConnectionFactory {

    String driverClassName;
    String connectionUrl;
    String dbUser;
    String dbPwd;

    private static ConnectionFactory connectionFactory = null;

    private ConnectionFactory() {
        try {
            try (InputStream input = new FileInputStream("/home/anton/Desktop/rest/config.properties")) {
                Properties prop = new Properties();
                prop.load(input);
                driverClassName = prop.getProperty("driverClassName");
                Class.forName(driverClassName);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        Connection conn = null;
        try (InputStream input = new FileInputStream("/home/anton/Desktop/rest/config.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            connectionUrl = prop.getProperty("connectionUrl");
            dbUser = prop.getProperty("dbUser");
            dbPwd = prop.getProperty("dbPwd");
            conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return conn;
    }

    public static ConnectionFactory getInstance() {
        if (connectionFactory == null) {
            connectionFactory = new ConnectionFactory();
        }
        return connectionFactory;
    }

}
