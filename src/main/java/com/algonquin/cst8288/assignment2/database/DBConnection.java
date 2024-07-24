package com.algonquin.cst8288.assignment2.database;

/**
 * @author Jatin
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    
    private static volatile DBConnection instance;
    private static Connection connection = null;
    
    // Database connection.
    private String serverUrl = "jdbc:mysql://localhost:3306/bookvault"; // URL 
    private String userString = "root"; // Username
    private String passwordString = "Jatin@16"; // Password
    private String driverString = "com.mysql.cj.jdbc.Driver"; 


    private DBConnection() {
        try {

        	Class.forName(driverString);
            connection = DriverManager.getConnection(serverUrl, userString, passwordString);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("JDBC Driver not found", e);
        } catch (SQLException e) {
            throw new RuntimeException("Cannot create a connection", e);
        }
    }

    
    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(serverUrl, userString, passwordString);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error reconnecting to the database", e);
        }
        return connection;
    }
    
    
    public static DBConnection getInstance() {
        if (instance == null) {
            synchronized (DBConnection.class) {
                if (instance == null && connection == null) {
                    instance = new DBConnection();
                }
            }
        }
        return instance;
    }

   

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
            } finally {
                connection = null;
            }
        }
    }

    
}