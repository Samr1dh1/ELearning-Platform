package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/project?autoReconnect=true&useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "Shouraya21@";
    private static Connection connection;

    // Private constructor to prevent instantiation
    private DBConnection() {}

    // Method to establish connection
    public static synchronized Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) { // Ensure connection is open
                Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL driver
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Database connected successfully.");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database.");
            e.printStackTrace();
        }
        return connection;
    }

    // Method to close connection
    public static synchronized void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null; // Reset connection after closing
                System.out.println("Database connection closed.");
            } catch (SQLException e) {
                System.out.println("Error closing the database connection.");
                e.printStackTrace();
            }
        }
    }
}
